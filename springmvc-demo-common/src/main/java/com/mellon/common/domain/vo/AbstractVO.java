package com.mellon.common.domain.vo;

import java.io.Serializable;

/**
 * All the VO classes must implements the AbstractVO class
 *
 * @author mellon
 * @version 1.0
 */
public abstract class AbstractVO implements Serializable{

    /**
     * Returns a string representation of the object.
     *
     * @return  a string representation of the object.
     */
    public abstract String toString();
}
