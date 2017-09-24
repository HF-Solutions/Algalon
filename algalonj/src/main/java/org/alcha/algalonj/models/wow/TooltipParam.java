package org.alcha.algalonj.models.wow;

import java.util.List;

/**
 * <p>Created by Alcha on Aug 22, 2017 @ 23:19.</p>
 * Copyright (c) 2017 Paranoid Devs.
 */

public class TooltipParam {
    private String mName;
    private List<?> mValue;

    public TooltipParam(String name, List<?> value) {
        mName = name;
        mValue = value;
    }

    public String getName() { return mName; }
    public List<?> getValue() { return mValue; }
}
