package com.xiaoniu.transaction.dataObject;

public class ItemDetailDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_detail.id
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_detail.item_id
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    private Integer itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_detail.address
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_detail.password
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_detail.intro
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    private String intro;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_detail.id
     *
     * @return the value of item_detail.id
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_detail.id
     *
     * @param id the value for item_detail.id
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_detail.item_id
     *
     * @return the value of item_detail.item_id
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_detail.item_id
     *
     * @param itemId the value for item_detail.item_id
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_detail.address
     *
     * @return the value of item_detail.address
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_detail.address
     *
     * @param address the value for item_detail.address
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_detail.password
     *
     * @return the value of item_detail.password
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_detail.password
     *
     * @param password the value for item_detail.password
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_detail.intro
     *
     * @return the value of item_detail.intro
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public String getIntro() {
        return intro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_detail.intro
     *
     * @param intro the value for item_detail.intro
     *
     * @mbg.generated Tue Mar 24 13:01:27 CST 2020
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}