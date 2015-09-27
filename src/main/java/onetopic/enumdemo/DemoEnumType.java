package onetopic.enumdemo;

/**
 * enum主要用于解决数据库解释和程序代码的匹配不一致问题
 * 比如数据里保持的是red,bule,green,而程序里解释为RED,BLUE,GREEN
 * @author yinliguo
 * @created 2015年9月27日 下午3:34:52
 */
public enum DemoEnumType
{
    
    RED("red"), BLUE("blue"), GREEN("green");
    
    private String dbName;
    
    private DemoEnumType(String dbName)
    {
        this.dbName = dbName;
    }
    
    @Override
    public String toString()
    {
        return dbName;
    }
}
