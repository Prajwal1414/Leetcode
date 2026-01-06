class LFUCache {
    class Node {
        Node head, tail,next, prev;
        int key, value;
        int frequency;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            frequency = 1;
        }
    }

    class List {
        int size;
        Node head, tail;

        List() {
            size = 0;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        void increaseFrequency(Node node) {

        }

        void insertAfterHead(Node node){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;            
        }

        void deleteNode(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }
    }

    private HashMap<Integer, Node> keyNodeMap;
    private HashMap<Integer, List> freqListMap;
    private int capacity;
    private int currSize, minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        currSize = 0;
        minFreq = 0;

        keyNodeMap = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key))
            return -1;

        Node node = keyNodeMap.get(key);
        updateFrequency(node);

        return node.value;

    }

    private void updateFrequency(Node node){

        freqListMap.get(node.frequency).deleteNode(node);

        if(node.frequency == minFreq && freqListMap.get(node.frequency).size == 0){
            minFreq++;
        }

        List nextHigherList = new List();

        if(freqListMap.containsKey(node.frequency + 1)){
            nextHigherList = freqListMap.get(node.frequency + 1);
        }

        node.frequency++;

        nextHigherList.insertAfterHead(node);

        freqListMap.put(node.frequency, nextHigherList);
    }

    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)){
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateFrequency(node);
        }
        else{
            if(currSize == capacity){
                List list = freqListMap.get(minFreq);
                keyNodeMap.remove(list.tail.prev.key);
                freqListMap.get(minFreq).deleteNode(list.tail.prev);
                currSize--;
            }

            currSize++;

            minFreq = 1;

            List listFreq = new List();
            if(freqListMap.containsKey(minFreq)){
                listFreq = freqListMap.get(minFreq);
            }

            Node newNode = new Node(key, value);

            listFreq.insertAfterHead(newNode);
            keyNodeMap.put(key, newNode);

            freqListMap.put(minFreq, listFreq);

        }


    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */