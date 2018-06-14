/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates.
 * Copyright (c) 2013, Regents of the University of California
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.graal.python.nodes.function;

import com.oracle.graal.python.builtins.objects.function.PArguments;
import com.oracle.graal.python.builtins.objects.function.PythonCallable;
import com.oracle.graal.python.builtins.objects.object.PythonObject;
import com.oracle.graal.python.nodes.PNode;
import com.oracle.graal.python.nodes.call.InvokeNode;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.ReportPolymorphism;

@ReportPolymorphism
@NodeChild(value = "arguments", type = PNode[].class)
public abstract class PythonBuiltinNode extends PNode {
    /**
     * This is obviously a slow path.
     */
    @TruffleBoundary
    public static String callAttributeSlowPath(PythonObject obj, String attributeId) {
        Object object = obj.getPythonClass().getAttribute(attributeId);
        PythonCallable callable;
        if (object instanceof PythonCallable) {
            callable = (PythonCallable) object;
        } else {
            callable = PythonCallable.require(obj.getAttribute(attributeId));
        }
        Object[] arguments = PArguments.create(1);
        PArguments.setArgument(arguments, 0, obj);
        InvokeNode invokeNode = InvokeNode.create(callable);
        return invokeNode.invoke(arguments).toString();
    }

    protected abstract PNode[] getArguments();

    public PythonBuiltinNode emptyCopy() {
        CompilerDirectives.transferToInterpreter();
        return getNodeFactory().getBuiltinNodeFactoryFor(this).createNode(new Object[]{null});
    }
}
