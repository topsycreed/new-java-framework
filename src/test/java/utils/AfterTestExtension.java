package utils;

import com.google.inject.Injector;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AfterTestExtension implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
//        if (extensionContext.getExecutionException().isPresent()) {
//            Injector injector = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)
//                    .get(Injector.class, Injector.class);
//
//            if (injector != null) {
//                AllureSteps allureSteps = injector.getInstance(AllureSteps.class);
//                allureSteps.screenshot();
//                allureSteps.sourceCode();
//            }
//        }
    }
}
