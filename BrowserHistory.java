package DSAProblems.sixth_day;

class BrowserHistory {

    class Node{
        String str;
        Node next;
        Node prev;

        Node(String str){
            this.str = str;
            this.next = null;
            this.prev = null;
        }
    }
    Node start;
    Node position;

    public BrowserHistory(String homepage) {
        start = new Node(homepage);
        position = start;
    }

    public void visit(String url) {
        Node tem = new Node(url);

        start.next = tem;
        tem.prev = start;
        start = tem;
        position = start;
    }

    public String back(int steps) {
        Node tem = start;

        while(steps > 0 && tem.prev != null){
            tem = tem.prev;
            steps--;
        }

        position = tem;
        start = tem;
        return tem.str;
    }

    public String forward(int steps) {
        Node tem = position;

        while(steps != 0 && tem.next != null){
            tem = tem.next;
            steps--;
        }

        start = tem;
        position = tem;
        return tem.str;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
