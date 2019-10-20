package quick.flash.blog.app.enums;

/**
 * 数据库操作类型
 *
 * @author lihao
 * @date 2019-09-14 00:27
 */
public enum OperateEnum {
    /**
     * 新增
     */
    ADD("add"),
    /**
     * 修改
     */
    MODIFY("modify"),
    /**
     * 删除
     */
    REMOVE("remove");

    private String operateType;

    OperateEnum(String operateType) {
        this.operateType = operateType;
    }

    public String getOperateType() {
        return operateType;
    }
}
