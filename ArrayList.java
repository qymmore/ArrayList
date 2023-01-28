public class ArrayList {
    private static int[] array; 
    private int size; 

    public ArrayList(){
        array = new int[10]; 
        size = 0; 
    }

    public void add(int element){ 
        if(size == array.length){  
            resize(); 
        }
        array[size] = element; 
        size++; 
    }

    public void add(int index, int element){ 
        if(index < 0 || index > size){ 
            throw new IndexOutOfBoundsException();
        }
        if(size == array.length){  
            resize();
        }
        for(int i = size; i > index; i--){
            array[i] = array[i - 1];
        }
        array[index] = element; 
        size++; 
    }

    public int get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index]; 
    }

    public void remove(int index) { 
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1]; 
        }
        size--;
    }

    public int size(){ 
        return size;
    }

    public boolean isEmpty(){ 
        return size == 0;
    }

    private void resize() { 
        int[] newArray = new int[array.length * 2]; 
        for (int i = 0; i < array.length; i++) { 
            newArray[i] = array[i]; 
        }
        array = newArray; 
    }

    public static void main(String[] args){ 
        ArrayList list = new ArrayList();

        list.add(1);
        list.add(2);

        list.add(1,3);

        list.add(5);
        list.remove(3);

        System.out.println("Index 0: " + list.get(0));
        System.out.println("Index 1: " + list.get(1));
        System.out.println("Index 2: " + list.get(2));



        System.out.println("Size of ArrayList: " + list.size());
        System.out.println("Is the ArrayList empty? " + list.isEmpty());
    }
}