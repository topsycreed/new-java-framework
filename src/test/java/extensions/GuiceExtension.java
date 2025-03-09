package extensions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;
import module.BaseModule;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class GuiceExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {
    @Getter
    private static Injector injector;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (injector == null) {
            injector = Guice.createInjector(new BaseModule());
        }

        context.getStore(ExtensionContext.Namespace.GLOBAL).put(Injector.class, injector);
    }

    @Override
    public void close() {
    }
}
