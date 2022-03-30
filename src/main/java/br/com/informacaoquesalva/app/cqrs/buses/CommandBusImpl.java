package br.com.informacaoquesalva.app.cqrs.buses;

import br.com.informacaoquesalva.app.cqrs.Command;
import br.com.informacaoquesalva.app.cqrs.annotations.CommandHandler;
import io.micronaut.context.BeanContext;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.qualifiers.Qualifiers;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class CommandBusImpl implements CommandBus {
    private final Map<Class<?>, br.com.informacaoquesalva.app.cqrs.CommandHandler<?, ?>> commandHandlers;

    @Inject
    public CommandBusImpl(BeanContext beanContext) {
        var beans = beanContext.getBeanDefinitions(Qualifiers.byStereotype(CommandHandler.class));
        var commandHandlers = new HashMap<Class<?>, br.com.informacaoquesalva.app.cqrs.CommandHandler<?, ?>>();
        for (BeanDefinition<?> bean : beans) {
            var annotation = bean.getAnnotation(CommandHandler.class);

            if (annotation != null) {
                var commandType = annotation.classValue("command");
                commandType.ifPresent(aClass -> commandHandlers.put(aClass, (br.com.informacaoquesalva.app.cqrs.CommandHandler) beanContext.getBean(bean)));
            }
        }
        this.commandHandlers = commandHandlers;
    }

    public <C extends Command<R>, R> R execute(C command) {
        try {
            @SuppressWarnings("unchecked") var commandHandler = (br.com.informacaoquesalva.app.cqrs.CommandHandler<C, R>) commandHandlers.get(command.getClass());
            return commandHandler.execute(command);
        } catch (ClassCastException e) {
            throw e;
        }
    }
}
