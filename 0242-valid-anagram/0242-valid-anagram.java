class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[]arr= new int[26];
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int a:arr)if(a!=0)return false;
        return true; 
        
        
    }
    //FOLLOW up-Use hash map
        // public boolean isAnagram(String s, String t) {
        // if(s == null || t == null)
        //     return false;
        // if (s.length() != t.length())
        //     return false;
        
        // HashMap<Character, Integer> table = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     // table.getOrDefault(key, default value): 
        //     table.put(s.charAt(i), table.getOrDefault(s.charAt(i), 0) + 1);
        //     table.put(t.charAt(i), table.getOrDefault(t.charAt(i), 0) - 1);
        // }
        // for (char c : table.keySet()) {
        //     if (table.get(c) != 0)
        //         return false;
        // }
        // return true;
    // }
}