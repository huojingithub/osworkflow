/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow.spi.hibernate;


/**
 *
 *
 * @author $Author: hani $
 * @version $Revision: 1.1.1.1 $
 */
public class HibernateCurrentStep extends HibernateStep {
    //~ Constructors ///////////////////////////////////////////////////////////

    public HibernateCurrentStep() {
    }

    public HibernateCurrentStep(HibernateStep step) {
        super(step);
    }
}