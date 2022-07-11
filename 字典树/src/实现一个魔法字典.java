class MagicDictionary {
    Trie root;
    public MagicDictionary() {
        root=new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie cur=root;
            for(int i=0;i<word.length();i++){
                int idx=word.charAt(i)-'a';
                if(cur.child[idx]==null){
                    cur.child[idx]=new Trie();
                }
                cur=cur.child[idx];
            }
            cur.isEnd=true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord,root,0,false);
    }
    boolean dfs(String searchWord,Trie node,int pos,boolean modified){
        if(pos==searchWord.length()){
            return modified&&node.isEnd;
        }
        int idx=searchWord.charAt(pos)-'a';
        if(node.child[idx]!=null){
            if(dfs(searchWord,node.child[idx],pos+1,modified)==true){
                return true;
            }
        }
        if(!modified){
            for(int i=0;i<26;i++){
                if(i!=idx&&node.child[i]!=null){
                    if(dfs(searchWord,node.child[i],pos+1,true)==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
class Trie{
    boolean isEnd;
    Trie[] child;
    public Trie(){
        isEnd=false;
        child=new Trie[26];
    }
}


public class 实现一个魔法字典 {
    public static void main(String[] args) {

    }
}
