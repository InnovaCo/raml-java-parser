/*
 * Copyright 2013 (c) MuleSoft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.raml.v2.internal.impl.commons.type;

import org.raml.v2.internal.impl.commons.nodes.TypeDeclarationNode;
import org.raml.v2.internal.impl.v10.type.TypeVisitor;

public class XmlSchemaExternalType extends AbstractExternalType
{
    public XmlSchemaExternalType(TypeDeclarationNode from, String schemaValue, String schemaPath, String internalFragment)
    {
        super(from, schemaValue, schemaPath, internalFragment);
    }

    public XmlSchemaExternalType(XmlSchemaExternalType externalType)
    {
        super(externalType);
    }

    @Override
    protected XmlSchemaExternalType copy()
    {
        return new XmlSchemaExternalType(this);
    }

    @Override
    public <T> T visit(TypeVisitor<T> visitor)
    {
        return visitor.visitXml(this);
    }

}
