package org.nameapi.client.services;

import com.optimaize.command4j.ExecutionContext;
import com.optimaize.soapworks.client.SoapBaseCommand;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.commonwsdl.context.SoapContext;
import org.nameapi.client.lib.NameApiKeys;

/**
 * Adds NameAPI-specific functionality to the BaseCommand.
 * @param <T> The wsdl port type.
 */
public abstract class NameApiBaseCommand<T, A, R> extends SoapBaseCommand<T, A, R> {

    protected NameApiBaseCommand(@NotNull Class<T> wsdlPortType) {
        super(wsdlPortType);
    }

    @NotNull
    protected SoapContext getContext(@NotNull ExecutionContext ec) {
        return ec.getMode().get(NameApiKeys.CONTEXT).get();
    }

}