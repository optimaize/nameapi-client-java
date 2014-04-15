package org.nameapi.client.lib;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.CommandExecutorBuilder;
import com.optimaize.command4j.ext.extensions.exception.exceptiontranslation.ExceptionTranslationExtension;
import com.optimaize.command4j.ext.extensions.failover.autoretry.AutoRetryExtension;
import com.optimaize.command4j.ext.extensions.logging.stdoutlogging.StdoutLoggingExtension;
import com.optimaize.command4j.ext.extensions.timeout.configurabletimeout.TimeoutExtension;

/**
 * When adding extensions here, it's like adding default interceptors
 * or default-whatever to any command that executes. Each ModeExtension
 * can choose what to do based on mode values.
 *
 * <p>You, the developer, may choose to use your IoC framework such as
 * Spring to inject the Extensions into an executor factory.</p>
 *
 * <p>The idea is to add all extensions that are available here, even
 * those that are not used. What is used is then configured using the
 * {@link com.optimaize.command4j.Mode}</p>
 */
public final class NameApiRemoteExecutors {

    private static final CommandExecutor SAME = create();

    public static CommandExecutor create() {
        return new CommandExecutorBuilder()
                .withExtension(new TimeoutExtension())
                .withExtension(new StdoutLoggingExtension())
                .withExtension(new ExceptionTranslationExtension())
                .withExtension(new AutoRetryExtension())
                .build();
        //could add name-api specific extensions here ...
    }

    /**
     * @return Always the same, immutable executor.
     */
    public static CommandExecutor get() {
        return SAME;
    }

}
