package com.anychart.anychart;

import java.util.Locale;

// class
/**
 * Adaptive Moving Average (AMA) indicator class.
{docs:Stock_Charts/Technical_Indicators/Adaptive_Moving_Average_(AMA)}Learn more about the AMA indicator.{docs}
 */
public class AMA extends JsObject {

    public AMA() {
        js.setLength(0);
        js.append("var aMA").append(++variableIndex).append(" = anychart.core.stock.indicators.aMA();");
        jsBase = "aMA" + variableIndex;
    }

    protected AMA(String jsBase) {
        js.setLength(0);
        this.jsBase = jsBase;
    }

    protected AMA(StringBuilder js, String jsBase, boolean isChain) {
        this.js = js;
        this.jsBase = jsBase;
        this.isChain = isChain;
    }

    protected String getJsBase() {
        return jsBase;
    }

    
    private Double fastPeriod;

    /**
     * Setter for the fast indicator period.
     */
    public AMA setFastPeriod(Double fastPeriod) {
        if (jsBase == null) {
            this.fastPeriod = fastPeriod;
        } else {
            this.fastPeriod = fastPeriod;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".fastPeriod(%f)", fastPeriod));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fastPeriod(%f)", fastPeriod));
                js.setLength(0);
            }
        }
        return this;
    }

    private Double period;

    /**
     * Setter for the indicator period.
     */
    public AMA setPeriod(Double period) {
        if (jsBase == null) {
            this.period = period;
        } else {
            this.period = period;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".period(%f)", period));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".period(%f)", period));
                js.setLength(0);
            }
        }
        return this;
    }

    private StockSeriesBase getSeries;

    /**
     * Getter for the indicator series.
     */
    public StockSeriesBase getSeries() {
        if (getSeries == null)
            getSeries = new StockSeriesBase(jsBase + ".series()");

        return getSeries;
    }

    private StockSeriesType type;
    private String type1;

    /**
     * Setter for the indicator series.
     */
    public AMA setSeries(StockSeriesType type) {
        if (jsBase == null) {
            this.type = null;
            this.type1 = null;
            
            this.type = type;
        } else {
            this.type = type;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".series(%s)", ((type != null) ? type.generateJs() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".series(%s)", ((type != null) ? type.generateJs() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Setter for the indicator series.
     */
    public AMA setSeries(String type1) {
        if (jsBase == null) {
            this.type = null;
            this.type1 = null;
            
            this.type1 = type1;
        } else {
            this.type1 = type1;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".series(%s)", wrapQuotes(type1)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".series(%s)", wrapQuotes(type1)));
                js.setLength(0);
            }
        }
        return this;
    }

    private Double slowPeriod;

    /**
     * Setter for the slow indicator period.
     */
    public AMA setSlowPeriod(Double slowPeriod) {
        if (jsBase == null) {
            this.slowPeriod = slowPeriod;
        } else {
            this.slowPeriod = slowPeriod;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".slowPeriod(%f)", slowPeriod));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".slowPeriod(%f)", slowPeriod));
                js.setLength(0);
            }
        }
        return this;
    }

    private String generateJSgetSeries() {
        if (getSeries != null) {
            return getSeries.generateJs();
        }
        return "";
    }


    protected String generateJsGetters() {
        StringBuilder jsGetters = new StringBuilder();

        jsGetters.append(super.generateJsGetters());

    
        jsGetters.append(generateJSgetSeries());

        return jsGetters.toString();
    }

    @Override
    protected String generateJs() {
        if (isChain) {
            js.append(";");
            isChain = false;
        }

        js.append(generateJsGetters());

        

        String result = js.toString();
        js.setLength(0);
        return result;
    }

}