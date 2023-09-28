package coco;

import java.util.HashMap;

public class SymbolTable {

    public SymbolTable parent; // parent scope
    private HashMap<String, Symbol> symbols; // map from name to Symbol

    public SymbolTable() {
        this.parent = null;
        this.symbols = new HashMap<String, Symbol>(); // might change to smart pointer
    }

    // lookup name in SymbolTable
    public Symbol lookup(String name) throws SymbolNotFoundError {

        if (symbols.containsKey(name)) {
            return symbols.get(name);
        } else {
            // check parent if exists
            if (parent != null) {
                return parent.lookup(name);
            } else {
                throw new SymbolNotFoundError(name);
            }
        }
    }

    // insert just name in SymbolTable (default type is VOID and line and pos are 0)
    public Symbol insert(String name) throws RedeclarationError {
        if (symbols.containsKey(name)) { // check if symbol already exists in current scope
            throw new RedeclarationError(name);
        } else {
            Symbol symbol = new Symbol(name);
            symbols.put(name, symbol);
            return symbol;
        }
    }

    // insert name and type in SymbolTable (default line and pos are 0)
    public Symbol insert(String name, Symbol.Type type) throws RedeclarationError {
        if (symbols.containsKey(name)) { // check if symbol already exists in current scope
            throw new RedeclarationError(name);
        } else {
            Symbol symbol = new Symbol(name, type);
            symbols.put(name, symbol);
            return symbol;
        }
    }

    // Fully specified insert
    public Symbol insert(String name, Symbol.Type type, int line, int pos) throws RedeclarationError {
        if (symbols.containsKey(name)) { // check if symbol already exists in current scope
            throw new RedeclarationError(name);
        } else {
            Symbol symbol = new Symbol(name, type, line, pos);
            symbols.put(name, symbol);
            return symbol;
        }
    }

}

class SymbolNotFoundError extends Error {

    private static final long serialVersionUID = 1L;
    private final String name;

    public SymbolNotFoundError(String name) {
        super("Symbol " + name + " not found.");
        this.name = name;
    }

    public String name() {
        return name;
    }
}

class RedeclarationError extends Error {

    private static final long serialVersionUID = 1L;
    private final String name;

    public RedeclarationError(String name) {
        super("Symbol " + name + " being redeclared.");
        this.name = name;
    }

    public String name() {
        return name;
    }
}
