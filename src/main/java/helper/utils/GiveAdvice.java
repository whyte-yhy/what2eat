package helper.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// getAdvice控制迭代，haveAdvice为0就结束，如果建议为null就说系统规则不完善
// 使用过的规则就不使用了
// tree的数据结构具有顺序性，因此content应该先排序
// 不能有相同的条件，否则会被覆盖掉

public class GiveAdvice {
    // 得到规则树
    Map ruleTree = LoadRealizerUtil.tree;
    // 已经fire的规则
    ArrayList<String> firedRules = new ArrayList<>();
    // bloom过滤器
    BloomFilter bloomFilter = LoadRealizerUtil.filter;

    Map<String, String> advice = new HashMap<>();

    public Map<String, String> getAdvice(String content) {
        //StringBuilder advice = new StringBuilder("");
        firedRules.clear();
        content = extractKeyWds(content);
        while (true) {
            String[] answer = process(content);

            //System.out.println(Arrays.toString(answer));
            if ("1".equals(answer[0])) {  // 1 表示有回答
                //advice.append(answer[1]);
                //System.out.println(answer[1]);
                content = content + " " + answer[2];
                //System.out.println(content);
            }
            else break;
        }
        return advice;
//        if ("".equals(advice.toString()))
//            return "抱歉，系统规则尚未完善，请联系管理员更新规则库。\n";
//        else return advice.toString();
    }

    // 操作了两张hashmap，一个是词树，一个是局部的树
    private String[] process(String content){
        Map nowMap = new HashMap();
        String nowWord;
        boolean flag = false;
        StringBuilder tempInductionProcess = new StringBuilder("");

        // 要返回的内容
        String haveAdvice = "0";
        StringBuilder conclusion = new StringBuilder("");
        String key = null;

        String[] inputAtomicWord = content.split(" ");
        Arrays.sort(inputAtomicWord,0,inputAtomicWord.length);
        //System.out.println(Arrays.toString(inputAtomicWord));
        for (int i=0;i<inputAtomicWord.length;i++){
            nowWord = inputAtomicWord[i];

            // 如果没进入推理环节
            if (nowMap == null || !flag){
                nowMap = (Map) ruleTree.get(nowWord);
                tempInductionProcess = new StringBuilder("");
                //System.out.println(nowMap);
            }
            if (nowMap != null){
                //System.out.println(nowMap);
                flag = true;
                tempInductionProcess.append(nowWord).append("，");
                if ("1".equals(nowMap.get("isEnd"))){
                    if (!firedRules.contains(tempInductionProcess.toString())) {
                        for (Object o : nowMap.entrySet()) {
                            Map.Entry entry = (Map.Entry) o;
                            key = (String) entry.getKey();
                            //System.out.println("key: "+key);
                            if (!key.equals("isEnd")) {  // 一个结论的数据结构为{结论:{isEnd=1}, isEnd:0}
                                // 存在结论
                                firedRules.add(tempInductionProcess.toString());
                                //System.out.println(firedRules);
                                advice.put(nowWord, key);  // new
                                StringBuilder ans = new StringBuilder("因为");
                                ans.append(tempInductionProcess);
                                conclusion.append(ans);
                                flag = false;

                                conclusion.append("所以").append(key).append("；\n");
                                break;
                            }
                        }
                        haveAdvice = "1";
                    }
                }
                if ((i+1)<inputAtomicWord.length)
                    nowMap = (Map) nowMap.get(inputAtomicWord[i+1]);
            }
            else {
                flag = false;
            }
        }
        return new String[]{haveAdvice, conclusion.toString(), key};
    }

    /**
     * 提取用户输入内容中对规则有效的内容（关键字）
     * @param content: 用户输入的内容
     * @return newContent: 提取的关键字，使符合规则表内容
     */
    private String extractKeyWds(String content){
        int counter = 0;
        StringBuilder extractedContent = new StringBuilder("");
        // 规范：前提不超过5个，每个前提长度不超过4
        // i控制每个元规则的长度，i取2、3、4
        // counter控制一句话最多包含5个前提（取前5个）
        for (int i=2;i<=4&&counter<5;i++) {
            for (int index=0;index+i<=content.length();index++) {  // <=因为subSequence不包含右边界
                String subContent = (String) content.subSequence(index, index+i);
                //System.out.println("subContent: "+subContent);
                if (bloomFilter.contains(subContent)) {
                    counter++;
                    extractedContent.append(subContent).append(" ");
                }
            }
        }
        String newContent = "";
        if (extractedContent.length()>0)
            newContent = extractedContent.deleteCharAt(extractedContent.length()-1).toString();
        //System.out.println("newContent: "+newContent);
        return newContent;
    }
}
