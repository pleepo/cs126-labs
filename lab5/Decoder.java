public class Decoder {
    private BinaryTreeNode<String> root;

    public Decoder() {
        root = new BinaryTreeNode<String>(""); // root node has no information

        /*
        // there must be a better way to do this...
        root.setLeft(new BinaryTreeNode<String>("e"));
        root.setRight(new BinaryTreeNode<String>("t"));
        root.getLeft().setLeft(new BinaryTreeNode<String>("i"));
        root.getLeft().setRight(new BinaryTreeNode<String>("a"));
        root.getRight().setLeft(new BinaryTreeNode<String>("n"));
        root.getRight().setRight(new BinaryTreeNode<String>("m"));

        // Ex 3
        root.getRight().getLeft().setLeft(new BinaryTreeNode<String>("d"));
        root.getRight().getLeft().setRight(new BinaryTreeNode<String>("k"));
        root.getRight().getRight().setRight(new BinaryTreeNode<String>("o"));
        root.getLeft().getRight().setLeft(new BinaryTreeNode<String>("r"));
        root.getLeft().getLeft().setLeft(new BinaryTreeNode<String>("s"));
        */
        // depth=1
        BinaryTreeNode<String> e = root.setLeft(new BinaryTreeNode<String>("e"));
        BinaryTreeNode<String> t = root.setRight(new BinaryTreeNode<String>("t"));

        // depth=2
        BinaryTreeNode<String> i = e.setLeft(new BinaryTreeNode<String>("i"));
        BinaryTreeNode<String> a = e.setRight(new BinaryTreeNode<String>("a"));
        BinaryTreeNode<String> n = t.setLeft(new BinaryTreeNode<String>("n"));
        BinaryTreeNode<String> m = t.setRight(new BinaryTreeNode<String>("m"));

        // depth=3
        BinaryTreeNode<String> s = i.setLeft(new BinaryTreeNode<String>("s"));
        BinaryTreeNode<String> u = i.setRight(new BinaryTreeNode<String>("u"));
        BinaryTreeNode<String> r = a.setLeft(new BinaryTreeNode<String>("r"));
        BinaryTreeNode<String> w = a.setRight(new BinaryTreeNode<String>("w"));
        BinaryTreeNode<String> d = n.setLeft(new BinaryTreeNode<String>("d"));
        BinaryTreeNode<String> k = n.setRight(new BinaryTreeNode<String>("k"));
        BinaryTreeNode<String> g = m.setLeft(new BinaryTreeNode<String>("g"));
        BinaryTreeNode<String> o = m.setRight(new BinaryTreeNode<String>("o"));

        // depth=4
        BinaryTreeNode<String> h = s.setLeft(new BinaryTreeNode<String>("h"));
        BinaryTreeNode<String> v = s.setRight(new BinaryTreeNode<String>("v"));
        BinaryTreeNode<String> f = u.setLeft(new BinaryTreeNode<String>("f"));
        BinaryTreeNode<String> l = r.setLeft(new BinaryTreeNode<String>("l"));
        BinaryTreeNode<String> p = w.setLeft(new BinaryTreeNode<String>("p"));
        BinaryTreeNode<String> j = w.setRight(new BinaryTreeNode<String>("j"));
        BinaryTreeNode<String> b = d.setLeft(new BinaryTreeNode<String>("b"));
        BinaryTreeNode<String> x = d.setRight(new BinaryTreeNode<String>("x"));
        BinaryTreeNode<String> c = k.setLeft(new BinaryTreeNode<String>("c"));
        BinaryTreeNode<String> y = k.setRight(new BinaryTreeNode<String>("y"));
        BinaryTreeNode<String> z = g.setLeft(new BinaryTreeNode<String>("z"));
        BinaryTreeNode<String> q = g.setRight(new BinaryTreeNode<String>("q"));  
    }

    //
    // An iterative version of the Morse code decoder
    //
    public String decode(String m) {
        BinaryTreeNode<String> ptr = root; // start at root of tree
        String str="?"; // decoded character

        // scan through the Morse string
        for (int i=0;i<m.length();i++)
        {
            if (ptr==null)
                str = "Yipes! Can't decode Morse string!";
            else
            if (m.charAt(i)=='.')
                ptr = ptr.getLeft(); // missing statement 1
            else
            if (m.charAt(i)=='-')
                ptr = ptr.getRight(); // missing statement 2
        }

        if (ptr!=null)
            str = (String)ptr.getValue();

        return str;
    }

    //
    // A Recursive version of the decoder
    //
    private String decodeR(BinaryTreeNode<String> n, String m) {
        String str="?";
        if (n!=null) {
            if (m.length()==0)
                str = n.getValue();
            else
            if (m.charAt(0)=='.')
                return decodeR(n.getLeft(), m.substring(1));//  Missing recursion here
            else
            if (m.charAt(0)=='-')
                return decodeR(n.getRight(), m.substring(1));//  Missing recursion here
        }
        return str;
    }

    //
    // public wrapper function to hide decodeR()
    //
    public String decode2(String m) {
        return decodeR(root, m);
    }
}
