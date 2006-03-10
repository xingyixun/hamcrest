/*  Copyright (c) 2000-2006 hamcrest.org
 */
package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.Matcher;


/**
 * Calculates the logical disjunction of two matchers. Evaluation is
 * shortcut, so that the second matcher is not called if the first
 * matcher returns <code>true</code>.
 */
public class Or implements Matcher {

    private final Matcher left;
    private final Matcher right;

    public Or(Matcher left, Matcher right) {
        this.left = left;
        this.right = right;
    }

    public boolean match(Object o) {
        return left.match(o) || right.match(o);
    }

    public void describeTo(Description description) {
        description.appendText("(");
        left.describeTo(description);
        description.appendText(" or ");
        right.describeTo(description);
        description.appendText(")");
    }
}
