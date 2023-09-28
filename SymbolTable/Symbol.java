package coco;

public class Symbol {

    public enum Type {
        VOID, INT, BOOL, INT_ARR, BOOL_ARR, FUNC
    }

    // Symbol Name
    private String name;
    // Symbol Type
    private Type type;
    // Symbol Declaration Line Number
    private int line;
    // Symbol Declaration Char Position
    private int pos;
    // Symbol Address (relative to the stack pointer, frame pointer, or data
    // pointer)
    private int address;
    // Symbol Size (in bytes) (for arrays)
    private int size;

    // Constructors

    public Symbol(String name) {
        this.name = name;
        this.type = Symbol.Type.VOID;
        this.line = 0;
        this.pos = 0;
        this.address = 0;
        this.size = 0;
    }

    public Symbol(String name, Type type) {
        this.name = name;
        this.type = type;
        this.line = 0;
        this.pos = 0;
        this.address = 0;
        this.size = 0;
    }

    public Symbol(String name, Type type, int line, int pos) {
        this.name = name;
        this.type = type;
        this.line = line;
        this.pos = pos;
        this.address = 0;
        this.size = 0; // Decide if/how later depending on how arrays are implemented
    }

    // Accessors
    public String name() {
        return name;
    }

    public Type type() {
        return type;
    }

    public int line() {
        return line;
    }

    public int pos() {
        return pos;
    }

    public int address() {
        return address;
    }

    public int size() {
        return size;
    }

    // Mutators
    public void setType(Type type) {
        this.type = type;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
