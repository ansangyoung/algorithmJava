// https://siyoon210.tistory.com/85 
// https://github.com/siyoon210/Algorithm-DataStructure/blob/master/src/exercise/hash/Hash.java 참고
import java.util.LinkedList;

class Node{
    String key;
    String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class HashTable{
    LinkedList<Node>[] datas;

    public HashTable(int size) {
        datas = new LinkedList[size];
    }

    int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
//System.out.println("getHashCode() return hashCode:" + hashCode);
        return hashCode;
    }

    int convertHashCodeToIndex(int hashCode) {
    	int hashCodeToIndex = hashCode % datas.length;
//System.out.println("convertHashCodeToIndex(hashCode):" + hashCodeToIndex);	
        return hashCodeToIndex;
    }

    // 이미 존재하는지 검사
    Node searchNode(LinkedList<Node> list, String key) {
        if (list == null) {
            return null;
        }
        for (Node node : list) {
//System.out.println("before if(key.equals(node.getKey())) in for searchNode():" + key.equals(node.getKey()) + ", key:" + key + ", node.getKey():" + node.getKey());
            if (key.equals(node.getKey())) {
                return node;
            }
        }
        return null;
    }

    void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertHashCodeToIndex(hashCode);
        LinkedList<Node> list = datas[index];
        
        if (list == null) {
            list = new LinkedList<>();
            datas[index] = list;
        }
        
        Node node = searchNode(list, key);
        
        if (node == null) {
            list.add(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    String getValueByKey(String key) {
        int hashCode = getHashCode(key);
        int index = convertHashCodeToIndex(hashCode);
        LinkedList<Node> list = datas[index];
        
        Node node = searchNode(list, key);
        
        return (node == null) ? "NOT FOUND!" : node.getValue();
    }
}

public class HashTableExam {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        
        hashTable.put("coding", "one");
        hashTable.put("interview", "two");
        hashTable.put("189", "three");
        hashTable.put("programming", "four");
        hashTable.put("problem", "five");
        hashTable.put("solution", "six");
//System.out.println("put() end");
//System.out.println("");
        System.out.println(hashTable.getValueByKey("coding"));
        System.out.println(hashTable.getValueByKey("interview"));
        System.out.println(hashTable.getValueByKey("189"));
        System.out.println(hashTable.getValueByKey("programming"));
        System.out.println(hashTable.getValueByKey("problem"));
        System.out.println(hashTable.getValueByKey("solution"));
        System.out.println(hashTable.getValueByKey("0"));
    }
}

