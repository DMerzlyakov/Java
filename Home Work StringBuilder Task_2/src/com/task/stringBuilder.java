package com.task;

class stringBuilder {

    private stringBuilderListener listen;

    private StringBuilder stringBuilder;

    public void setListen(MyListener listen) {
        this.listen = listen;
    }

    public stringBuilder() {
        stringBuilder = new StringBuilder();
    }

    private void notifyListener(){
        if(listen != null){
            listen.onChange(this);
        }
    }

    public stringBuilder append(Object obj) {
        stringBuilder.append(obj);
        notifyListener();
        return this;
    }

    public stringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        notifyListener();
        return this;
    }

    public stringBuilder insert(int index, char[] str, int offset, int len) {
        stringBuilder.insert(index, str, offset, len);
        notifyListener();
        return this;
    }


    public String toString() {
        return stringBuilder.toString();
    }
}