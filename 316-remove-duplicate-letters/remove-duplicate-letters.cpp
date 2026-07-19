class Solution {
public:
    string removeDuplicateLetters(string s) {
        vector<int> lastIndex(26);
        vector<bool> visited(26, false);
        stack<char> st;
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s[i] - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s[i];
            if (visited[ch - 'a']) {
                continue;
            }
            while (!st.empty() && ch < st.top() && lastIndex[st.top() - 'a'] > i) {
                visited[st.top() - 'a'] = false;
                st.pop();
            }
            st.push(ch);
            visited[ch - 'a'] = true;
        }
        string ans;
        while (!st.empty()) {
            ans += st.top();
            st.pop();
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};