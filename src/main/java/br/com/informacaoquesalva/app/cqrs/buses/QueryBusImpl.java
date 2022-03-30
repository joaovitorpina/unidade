package br.com.informacaoquesalva.app.cqrs.buses;

import br.com.informacaoquesalva.app.cqrs.Query;
import br.com.informacaoquesalva.app.cqrs.annotations.QueryHandler;
import io.micronaut.context.BeanContext;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.qualifiers.Qualifiers;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class QueryBusImpl implements QueryBus {
    private final Map<Class<?>, br.com.informacaoquesalva.app.cqrs.QueryHandler<?, ?>> queryHandlers;

    @Inject
    public QueryBusImpl(BeanContext beanContext) {
        var beans = beanContext.getBeanDefinitions(Qualifiers.byStereotype(QueryHandler.class));
        var queryHandler = new HashMap<Class<?>, br.com.informacaoquesalva.app.cqrs.QueryHandler<?, ?>>();
        for (BeanDefinition<?> bean : beans) {
            var annotation = bean.getAnnotation(QueryHandler.class);

            if (annotation != null) {
                var queryType = annotation.classValue("query");
                queryType.ifPresent(aClass -> queryHandler.put(aClass, (br.com.informacaoquesalva.app.cqrs.QueryHandler) beanContext.getBean(bean)));
            }
        }
        this.queryHandlers = queryHandler;
    }

    public <Q extends Query<R>, R> R execute(Q query) {
        try {
            @SuppressWarnings("unchecked") var queryHandler = (br.com.informacaoquesalva.app.cqrs.QueryHandler<Q, R>) queryHandlers.get(query.getClass());
            return queryHandler.execute(query);
        } catch (ClassCastException e) {
            throw e;
        }
    }
}
