package br.com.informacaoquesalva.domain.seedwork;

import java.util.List;

public abstract class ValueObject {
    protected abstract List<Object> getEqualityComponents();

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ValueObject other) || other.getClass() != this.getClass()) {
            return false;
        }

        return this.getEqualityComponents().equals(other.getEqualityComponents());
    }

    @Override
    public int hashCode() {
        return getEqualityComponents().stream().map((x) -> x != null ? x.hashCode() : 0).reduce(0, (x, y) -> x ^ y);
    }
}
