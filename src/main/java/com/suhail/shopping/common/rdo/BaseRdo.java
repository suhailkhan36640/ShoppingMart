/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.common.rdo;

import javax.xml.crypto.Data;
import java.util.Date;

public class BaseRdo<T> {
    private T data;
    private Date date;

    public BaseRdo() {

    }

    public BaseRdo(T data, Date date) {
        this.data = data;
        this.date = date;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
