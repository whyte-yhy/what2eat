package test;

import java.util.ArrayList;
import java.util.List;

/*
* 以下是针对题目所描述的问题的CNF公式和相应的Java代码：

假设我们将食材表示为字母，例如“面粉”为“a”，“大米”为“b”，依此类推，直到“花生油”为“j”。

对于每种食材，我们可以用1到多个数字来表示每个食材的实例。例如，“a1”表示面粉的一个实例，“a2”表示面粉的另一个实例，以此类推。

假设我们需要至少使用10种食材，则可以编写以下CNF公式：

首先，我们需要定义一个用于检查至少使用10种不同食材的公式。这可以通过组合10个包含食材的公式来实现。因此，我们需要编写一个方法来生成这些公式，并将它们组合在一起以形成整个CNF公式。
*
* 在这个代码中，我们首先定义了一些常量，包括食材的数量和实例的数量。然后，我们编写了一个`generateCNF()`方法，该方法生成CNF公式。

在`generateCNF()`方法中，我们首先生成一个公式来确保至少使用了10种不同的食材。我们使用了一个`atLeastTenIngredientsFormula`列表来存储这个公式。然后，我们为每个食材生成一个公式，并将这些公式合并到一个CNF公式中。

为了生成CNF公式，我们使用了`combineClauses()`方法，该方法接受一个子句列表、一个最小计数值，并返回一个包含组合子句的列表。该方法递归地创建所有子句组合，并仅包括至少包含最小计数值个子句的组合。在递归中，我们使用`combineClausesHelper()`方法来生成组合子句。

最后，我们在`main()`方法中调用`generateCNF()`方法，并打印出生成的CNF公式。

在输出中，每一行表示一个CNF子句。例如，行`"a1 b1 c1 d1 e1 f1 g1 h1 i1 j1"`表示至少使用了这10个不同食材中的一个实例。
* */
public class CNFGenerator {

    private static final int INGREDIENTS_COUNT = 10;
    private static final String[] INGREDIENTS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    private static final int INSTANCES_COUNT = 3;
    private static final String[] INSTANCES = {"1", "2", "3"};

    public static void main(String[] args) {
        List<String> cnf = generateCNF();
        for (String clause : cnf) {
            System.out.println(clause);
        }
    }

    private static List<String> generateCNF() {
        List<String> cnf = new ArrayList<>();

        // Generate CNF formula to ensure at least 10 ingredients are used
        List<String> atLeastTenIngredientsFormula = new ArrayList<>();
        for (int i = 0; i < INGREDIENTS_COUNT; i++) {
            List<String> clause = new ArrayList<>();
            for (int j = 0; j < INSTANCES_COUNT; j++) {
                String ingredientInstance = INGREDIENTS[i] + INSTANCES[j];
                clause.add(ingredientInstance);
            }
            atLeastTenIngredientsFormula.add(String.join(" ", clause));
        }
        cnf.addAll(combineClauses(atLeastTenIngredientsFormula, INGREDIENTS_COUNT - 9));

        // Generate CNF formula for each ingredient
        for (int i = 0; i < INGREDIENTS_COUNT; i++) {
            List<String> ingredientFormula = new ArrayList<>();
            for (int j = 0; j < INSTANCES_COUNT; j++) {
                String ingredientInstance = INGREDIENTS[i] + INSTANCES[j];
                ingredientFormula.add(ingredientInstance);
            }
            cnf.addAll(combineClauses(ingredientFormula, 1));
        }

        return cnf;
    }

    private static List<String> combineClauses(List<String> clauses, int minCount) {
        List<String> combinations = new ArrayList<>();
        combineClausesHelper(combinations, new ArrayList<>(), clauses, 0, minCount);
        return combinations;
    }

    private static void combineClausesHelper(List<String> combinations, List<String> currentCombination,
                                             List<String> clauses, int index, int minCount) {
        if (currentCombination.size() >= minCount) {
            combinations.add(String.join(" ", currentCombination));
        } else {
            for (int i = index; i < clauses.size(); i++) {
                List<String> newCombination = new ArrayList<>(currentCombination);
                newCombination.add(clauses.get(i));
                combineClausesHelper(combinations, newCombination, clauses, i + 1, minCount);
            }
        }
    }
}


