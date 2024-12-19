package com.dailyDev.collections;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;

public class HandleNullValues {
   public static Function<Collection<?>, Long> countNulls = collection -> collection.stream().filter(Objects::isNull).count();
}
