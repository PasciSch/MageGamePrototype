package magegameprototype;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Element
{
    Neutral,
    
    Nature,
    
    Water,
    
    Fire;
    
    private static final Map<Element, Element> superiorMap;
    private static final Map<Element, Element> inferiorMap;
    
    static {
        EnumMap<Element, Element> tempSuperiorMap = new EnumMap<>(Element.class);
        tempSuperiorMap.put(Fire, Water);
        tempSuperiorMap.put(Water, Nature);
        tempSuperiorMap.put(Nature, Fire);
        tempSuperiorMap.put(Neutral, null);
        superiorMap = tempSuperiorMap;
    
        EnumMap<Element, Element> tempInferiorMap = new EnumMap<>(Element.class);
        tempInferiorMap.put(Water, Fire);
        tempInferiorMap.put(Nature, Water);
        tempInferiorMap.put(Fire, Nature);
        tempInferiorMap.put(Neutral, null);
        inferiorMap = tempInferiorMap;
    }
    
    public boolean isSuperiorTo(Element element)
    {
        Element superior = superiorMap.get(element);
        return this.equals(superior);
    }
    
    public boolean isInferiorTo(Element element)
    {
        Element inferior = inferiorMap.get(element);
        return this.equals(inferior);
    }
}
