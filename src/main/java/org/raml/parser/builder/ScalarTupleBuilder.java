package org.raml.parser.builder;

import org.raml.parser.resolver.DefaultScalarTupleHandler;
import org.raml.parser.utils.ReflectionUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.yaml.snakeyaml.nodes.ScalarNode;


public class ScalarTupleBuilder extends DefaultTupleBuilder<ScalarNode, ScalarNode>
{

    private String fieldName;
    private Class<?> type;


    public ScalarTupleBuilder(String field, Class<?> type)
    {
        super(new DefaultScalarTupleHandler(ScalarNode.class, field));
        fieldName = field;
        this.type = type;

    }


    @Override
    public Object buildValue(Object parent, ScalarNode node)
    {

        final String value = node.getValue();
        Object converted;
        if (type.isEnum())
        {
            converted = Enum.valueOf((Class) type, value.toUpperCase());
        }
        else
        {
            converted = ConvertUtils.convert(value, type);
        }
        ReflectionUtils.setProperty(parent, fieldName, converted);

        return parent;
    }

}