package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.serde.annotation.SerdeImport;
import one.microstream.storage.restadapter.types.ViewerObjectDescription;

@Controller
@SerdeImport(value = ViewerObjectDescription.class, mixin = MyController.ViewerObjectDescriptionMixin.class)
public class MyController {

    private static final ViewerObjectDescription REF1 = createOneDescription("1000000000000000030", "1", "50c075d5-6116-4edb-9c2a-c91e3b84503d");
    private static final ViewerObjectDescription REF2 = createOneDescription("1000000000000000032", "0", "Sergio");

    @Get("/bad")
    public ViewerObjectDescription bad() {
        ViewerObjectDescription desc = createRootObject();
        desc.setReferences(new ViewerObjectDescription[]{ REF1, REF2, null });
        return desc;
    }

    @Get("/good")
    public ViewerObjectDescription good() {
        ViewerObjectDescription desc = createRootObject();
        desc.setReferences(new ViewerObjectDescription[]{ REF1, REF2 });
        return desc;
    }

    private ViewerObjectDescription createRootObject() {
        ViewerObjectDescription desc = new ViewerObjectDescription();
        desc.setObjectId("1000000000000000031");
        desc.setTypeId("1000069");
        desc.setLength("3");
        desc.setData(new Object[]{"1", "2", "3"});
        return desc;
    }

    private static ViewerObjectDescription createOneDescription(String objectId, String variableLength, String data) {
        ViewerObjectDescription ref1 = new ViewerObjectDescription();
        ref1.setObjectId(objectId);
        ref1.setTypeId("30");
        ref1.setLength("1");
        ref1.setVariableLength(new String[]{variableLength});
        ref1.setSimplified(true);
        ref1.setData(new Object[]{data});
        return ref1;
    }

    // A mixin to keep showing null values and empty lists
    @SuppressWarnings("DefaultAnnotationParam")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    interface ViewerObjectDescriptionMixin {
    }
}
