/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow.util.jndi;

import com.opensymphony.workflow.*;
import com.opensymphony.workflow.spi.WorkflowEntry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 *
 * @author $Author: hani $
 * @version $Revision: 1.1.1.1 $
 */
public class JNDIRegister implements Register {
    //~ Static fields/initializers /////////////////////////////////////////////

    private static final Log log = LogFactory.getLog(JNDIRegister.class);

    //~ Methods ////////////////////////////////////////////////////////////////

    public Object registerVariable(WorkflowContext context, WorkflowEntry entry, Map args) throws WorkflowException {
        String location = (String) args.get(AbstractWorkflow.JNDI_LOCATION);

        Register r = null;

        try {
            r = (Register) new InitialContext().lookup(location);
        } catch (NamingException e) {
            String message = "Could not look up JNDI register at: " + location;
            throw new WorkflowException(message, e);
        }

        return r.registerVariable(context, entry, args);
    }
}