package br.com.informacaoquesalva.app.cqrs.buses;

import br.com.informacaoquesalva.app.cqrs.Event;
import br.com.informacaoquesalva.app.cqrs.annotations.EventHandler;
import io.micronaut.context.BeanContext;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.qualifiers.Qualifiers;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class EventBusImpl implements EventBus {
    private final Map<Class<?>, br.com.informacaoquesalva.app.cqrs.EventHandler<?>> eventHandlers;

    @Inject
    public EventBusImpl(BeanContext beanContext) {
        var beans = beanContext.getBeanDefinitions(Qualifiers.byStereotype(EventHandler.class));
        var eventHandlers = new HashMap<Class<?>, br.com.informacaoquesalva.app.cqrs.EventHandler<?>>();
        for (BeanDefinition<?> bean : beans) {
            var annotation = bean.getAnnotation(EventHandler.class);

            if (annotation != null) {
                var eventType = annotation.classValue("event");
                eventType.ifPresent(aClass -> eventHandlers.put(aClass, (br.com.informacaoquesalva.app.cqrs.EventHandler) beanContext.getBean(bean)));
            }
        }
        this.eventHandlers = eventHandlers;
    }

    @Override
    public <E extends Event> void publish(E event) {
        try {
            @SuppressWarnings("unchecked") var eventHandler = (br.com.informacaoquesalva.app.cqrs.EventHandler<E>) eventHandlers.get(event.getClass());
            eventHandler.execute(event);
        } catch (ClassCastException e) {
            throw e;
        }
    }

    @Override
    public <E extends Event> void publishAll(List<E> events) {
        for (E event : events) {
            publish(event);
        }
    }
}
