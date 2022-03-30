package br.com.informacaoquesalva.domain.seedwork;

import br.com.informacaoquesalva.app.cqrs.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Entity {
    private final List<Event> domainEvents;
    private Integer requestedHashCode;
    private Long id;

    protected Entity() {
        domainEvents = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Event> getDomainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }

    public void addDomainEvent(Event event) {
        domainEvents.add(event);
    }

    public void removeDomainEvent(Event event) {
        domainEvents.remove(event);
    }

    public void clearDomainEvents() {
        domainEvents.clear();
    }

    public Boolean isTransient() {
        return this.id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entity item) || item.getClass() != this.getClass())
            return false;

        if (item.isTransient() || this.isTransient())
            return false;
        else
            return Objects.equals(item.id, this.id);
    }

    @Override
    public int hashCode() {
        if (!isTransient()) {
            if (requestedHashCode == null) {
                requestedHashCode = this.id.hashCode() ^ 31;
            }

            return requestedHashCode;
        } else {
            return super.hashCode();
        }
    }
}
