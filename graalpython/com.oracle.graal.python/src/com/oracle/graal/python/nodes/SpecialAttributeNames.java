/*
 * Copyright (c) 2018, Oracle and/or its affiliates.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or data
 * (collectively the "Software"), free of charge and under any and all copyright
 * rights in the Software, and any and all patent rights owned or freely
 * licensable by each licensor hereunder covering either (i) the unmodified
 * Software as contributed to or provided by such licensor, or (ii) the Larger
 * Works (as defined below), to deal in both
 *
 * (a) the Software, and
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 *     one is included with the Software (each a "Larger Work" to which the
 *     Software is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.graal.python.nodes;

import com.oracle.truffle.api.object.HiddenKey;

public abstract class SpecialAttributeNames {
    public static final String __DOC__ = "__doc__";
    public static final String __DEFAULTS__ = "__defaults__";
    public static final String __CODE__ = "__code__";
    public static final String __GLOBALS__ = "__globals__";
    public static final String __CLOSURE__ = "__closure__";
    public static final String __ANNOTATIONS__ = "__annotations__";
    public static final String __KWDEFAULTS__ = "__kwdefaults__";
    public static final String __SELF__ = "__self__";
    public static final String __FUNC__ = "__func__";
    public static final String __MODULE__ = "__module__";
    public static final String __DICT__ = "__dict__";
    public static final String __CLASS__ = "__class__";
    public static final String __BASES__ = "__bases__";
    public static final String __NAME__ = "__name__";
    public static final String __QUALNAME__ = "__qualname__";
    public static final String __MRO__ = "__mro__";
    public static final String __LOADER__ = "__loader__";
    public static final String __PACKAGE__ = "__package__";
    public static final String __SPEC__ = "__spec__";
    public static final String __PATH__ = "__path__";
    public static final String __FILE__ = "__file__";
    public static final String __CACHED__ = "__cached__";
    public static final String __TRACEBACK__ = "__traceback__";
    public static final String __BASICSIZE__ = "__basicsize__";
    public static final String __NEW__ = "__new__";

    /* hidden keys */
    public static final HiddenKey __GET_BUFFER__ = new HiddenKey("__get_buffer__");
    public static final HiddenKey __RELEASE_BUFFER__ = new HiddenKey("__release_buffer__");
}
