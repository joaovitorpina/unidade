package br.com.informacaoquesalva.app.cqrs;

public interface CommandHandler<C extends Command<R>, R> {
    R execute(C command);
}
