public class ML {
    public static  ArrayList<String> generateTags(String text) throws MonkeyLearnException {
        ArrayList<String >result = new ArrayList<>();
        MonkeyLearn ml = new MonkeyLearn("63843d7bcd5912954e0e2e6bb5e358879b7bbef1");
        String modelId = "cl_pYbkxoYU";
        String[] data1 = {text};

        MonkeyLearnResponse res1 = ml.classifiers.classify(modelId, data1, true);
        String res= res1.arrayResult.get(0).toString();

        JSONArray obj = new JSONArray(res) ;
        for (int i=0;i<obj.length();i++){
        result.add((String)obj.getJSONArray(i).getJSONObject(0).get("label"));
        }
        return result;
    }
}