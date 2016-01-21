package assignment2;


public class Table< V extends ClonableInterface<V>,K extends DataInterface<K>> implements TableInterface<V,K>{
    
    List<Variable> table;
     
    Table(){
        Variable variable;
        table = new List<>();
    }
 
    @Override
    public void insert(V value, K key) {
        Variable newVariable = new Variable(value, key);
        table.insert(newVariable);
    }
 
    @Override
    public V retrieve(K key) {
        table.goToFirst();
        for (int i = 0; i < table.size(); i++) {
            if (table.retrieve().key.equals(key)) {
                return table.retrieve().value;
            }
            table.goToNext();
        }
        return null;
    }
 
    // TODO vragen of we ipv key ook identifier mogen gebruiken
    
    @Override
    public boolean contains(K key) {
        table.goToFirst();
        for (int i = 0; i < table.size(); i++) {
            if (table.retrieve().key.equals(key)) {
                return true;
            } else {
                table.goToNext();
            }
        }
        return false;
    }   
 
    @Override
    public TableInterface<V, K> clone() {
        Table<V,K> clonedTable = new Table<>();
        table.goToFirst();
        for (int i = 0; i < table.size(); i ++) {
            clonedTable.insert(table.retrieve().value, table.retrieve().key);
        }
        return clonedTable;
    }
     
    private class Variable implements DataInterface<Variable>{
 
        K key;
        V value;
 
        public Variable(V K) {
            this(null, null);
        }
 
        public Variable(V value, K key) {
            this.key = key;
            this.value = value;
        }
 
        @Override
        public Table<V, K>.Variable clone() {
            Variable clonedVariable = new Variable(value, key);
            return clonedVariable;
        }
 
        @Override
        public int compareTo(Table<V, K>.Variable o) {
            if (key.equals(o.key)){
                return 1;
            } else {
                return 0;
            }
        }
    }
     
}

