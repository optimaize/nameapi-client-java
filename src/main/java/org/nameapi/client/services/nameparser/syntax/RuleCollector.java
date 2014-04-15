package org.nameapi.client.services.nameparser.syntax;

import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Builder for the list of {@link NameParserRule rules}.
 *
 * <p>It's a simple collector, with the advantage that it detects some programming
 * mistakes early:
 * <ul>
 *   <li>not adding any rule</li>
 *   <li>using the same rule name twice</li>
 * </ul></p>
 *
 * @author Fabian Kessler
 */
public class RuleCollector {

    private final Set<String> names = new HashSet<>();
    private final ArrayList<NameParserRule> list = new ArrayList<>();

    @NotNull
    public RuleCollector add(@NotNull NameParserRule rule) {
        if (names.contains(rule.getName())) {
            throw new IllegalStateException("Already added a rule with name >>>"+rule.getName()+"<<<!");
        }
        names.add(rule.getName());
        list.add(rule);
        return this;
    }

    /**
     * @return The items in an immutable list to feed to the Command.
     * @throws IllegalStateException If no rules have been added yet.
     */
    @NotNull
    public List<NameParserRule> toList() throws IllegalStateException {
        if (list.isEmpty()) {
            throw new IllegalStateException("No rules added yet!");
        }
        return ImmutableList.copyOf(list);
    }

    /**
     * @return The list as used internally, modifiable.
     */
    @NotNull
    public List<NameParserRule> asList() {
        return list;
    }

    @Override
    public String toString() {
        return "RuleCollector{" +
                "list=" + list +
                '}';
    }
}
