package br.com.informacaoquesalva.domain.seedwork;

public abstract class Enumeration {
    private final Integer id;
    private final String name;

    protected Enumeration(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
