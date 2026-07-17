class Solution {
public:
    vector<int> gcdValues(vector<int>& nums, vector<long long>& queries) {
        int mx = *max_element(nums.begin(), nums.end());

        vector<int> freq(mx + 1, 0);
        for (int x : nums) freq[x]++;

        // cnt[g] = numbers divisible by g
        vector<long long> cnt(mx + 1, 0);
        for (int g = 1; g <= mx; g++) {
            for (int j = g; j <= mx; j += g)
                cnt[g] += freq[j];
        }

        // exact[g] = pairs with gcd exactly g
        vector<long long> exact(mx + 1, 0);

        for (int g = mx; g >= 1; g--) {
            long long pairs = cnt[g] * (cnt[g] - 1) / 2;
            for (int j = g + g; j <= mx; j += g)
                pairs -= exact[j];
            exact[g] = pairs;
        }

        // prefix counts in sorted gcdPairs
        vector<long long> pref(mx + 1, 0);
        for (int g = 1; g <= mx; g++)
            pref[g] = pref[g - 1] + exact[g];

        vector<int> ans;
        ans.reserve(queries.size());

        for (long long k : queries) {
            int g = lower_bound(pref.begin() + 1, pref.end(), k + 1) - pref.begin();
            ans.push_back(g);
        }

        return ans;
    }
};