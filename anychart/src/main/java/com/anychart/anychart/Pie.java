package com.anychart.anychart;

import com.anychart.anychart.application.MyApplication;
import com.anychart.anychart.chart.common.ListenersInterface;

import java.util.List;
import java.util.Locale;

// chart class
/**
 * Pie (Donut) chart class.<br/>
<b>Note:</b> Use {@link anychart#pie} method to get an instance of this class:
 */
public class Pie extends SeparateChart {

    protected Pie(String name) {
        super(name);

        js.setLength(0);
        js.append(String.format(Locale.US, "chart = %s();", name));
        jsBase = "chart";
    }

    public Pie setData(SingleValueDataSet data) {
        if (!data.isEmpty()) {
            if (isChain) {
                js.append(";");
                isChain = false;
            }

            js.append(jsBase).append(".data([");

            js.append(data.generateJs());

            js.append("]);");
        }

        return this;
    }

    public Pie setData(List<DataEntry> data) {
        if (!data.isEmpty()) {
            if (isChain) {
                js.append(";");
                isChain = false;
            }

            js.append(jsBase).append(".data([");

            for (DataEntry dataEntry : data) {
                js.append(dataEntry.generateJs()).append(",");
            }
            js.setLength(js.length() - 1);

            js.append("]);");
        }

        return this;
    }

    public Pie setData(List<DataEntry> data, TreeFillingMethod mode) {
        if (!data.isEmpty()) {
            if (isChain) {
                js.append(";");
                isChain = false;
            }

            js.append(jsBase).append(".data([");

            for (DataEntry dataEntry : data) {
                js.append(dataEntry.generateJs()).append(",");
            }
            js.setLength(js.length() - 1);

            js.append("], ").append((mode != null) ? mode.generateJs() : "null").append(");");
        }

        return this;
    }

    public Pie setData(Mapping mapping) {
        if (isChain) {
            js.append(";");
            isChain = false;
        }
        js.append(mapping.generateJs());

        js.append(jsBase).append(".data(").append(mapping.getJsBase()).append(");");

        return this;
    }

    public void setOnClickListener(ListenersInterface.OnClickListener listener) {
        if (isChain) {
            js.append(";");
            isChain = false;
        }
        js.append("chart.listen('pointClick', function(e) {");
        if (listener.getFields() != null) {
            js.append("var result = ");
            for (String field : listener.getFields()) {
                js.append(String.format(Locale.US, "'%1$s' + ':' + e.point.get('%1$s') + ',' +", field));
            }
            js.setLength(js.length() - 8);
            js.append(";");

            js.append("android.onClick(result);");
        } else {
            js.append("android.onClick(null);");
        }
        js.append("});");

        MyApplication.getInstance().getJavaScriptInterface().setOnClickListener(listener);
    }

    
    private Double connectorLength;
    private String connectorLength1;

    /**
     * Setter for the outside labels connector length.<br/>
<b>Note:</b> Works only with outside labels mode.
     */
    public Pie setConnectorLength(Double connectorLength) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".connectorLength(%f)", connectorLength));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".connectorLength(%f)", connectorLength));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the outside labels connector length.<br/>
<b>Note:</b> Works only with outside labels mode.
     */
    public Pie setConnectorLength(String connectorLength1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".connectorLength(%s)", wrapQuotes(connectorLength1)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".connectorLength(%s)", wrapQuotes(connectorLength1)));
            js.setLength(0);
        }
        return this;
    }

    private Stroke connectorStroke;
    private ColoredFill connectorStroke1;
    private String connectorStroke2;
    private Double thickness;
    private String dashpattern;
    private StrokeLineJoin lineJoin;
    private StrokeLineCap lineCap;

    /**
     * Setter for outside labels connectors stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs} <br/>
<b>Note: </b> Works only with outside labels mode.
     */
    public Pie setConnectorStroke(Stroke connectorStroke, Double thickness, String dashpattern, StrokeLineJoin lineJoin, StrokeLineCap lineCap) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".connectorStroke(%s, %f, %s, %s, %s)", ((connectorStroke != null) ? connectorStroke.generateJs() : "null"), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".connectorStroke(%s, %f, %s, %s, %s)", ((connectorStroke != null) ? connectorStroke.generateJs() : "null"), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for outside labels connectors stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs} <br/>
<b>Note: </b> Works only with outside labels mode.
     */
    public Pie setConnectorStroke(ColoredFill connectorStroke1, Double thickness, String dashpattern, StrokeLineJoin lineJoin, StrokeLineCap lineCap) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".connectorStroke(%s, %f, %s, %s, %s)", ((connectorStroke1 != null) ? connectorStroke1.generateJs() : "null"), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".connectorStroke(%s, %f, %s, %s, %s)", ((connectorStroke1 != null) ? connectorStroke1.generateJs() : "null"), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for outside labels connectors stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs} <br/>
<b>Note: </b> Works only with outside labels mode.
     */
    public Pie setConnectorStroke(String connectorStroke2, Double thickness, String dashpattern, StrokeLineJoin lineJoin, StrokeLineCap lineCap) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".connectorStroke(%s, %f, %s, %s, %s)", wrapQuotes(connectorStroke2), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".connectorStroke(%s, %f, %s, %s, %s)", wrapQuotes(connectorStroke2), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));
            js.setLength(0);
        }
        return this;
    }


    private View getData;

    /**
     * Getter for the chart data.
     */
    public View getData() {
        if (getData == null)
            getData = new View(jsBase + ".data()");

        return getData;
    }

    /**
     * Setter for the chart data.<br/>
Learn more about mapping at {@link anychart.data.Mapping}.
     */
    public Pie data(List<DataEntry> data) {
        if (isChain) {
            js.append(";");
            isChain = false;
        }

        if (!data.isEmpty()) {
            StringBuilder resultData = new StringBuilder();
            resultData.append("[");
            for (DataEntry dataEntry : data) {
                resultData.append(dataEntry.generateJs()).append(",");
            }
            resultData.setLength(resultData.length() - 1);
            resultData.append("]");

            js.append(String.format(Locale.US, "var setData" + ++variableIndex + " = " + jsBase + ".data(%s);", resultData.toString()));
        }
        return this;
    }


    /**
     * 
     */
    public Pie data(View mapping) {
        if (isChain) {
            js.append(";");
            isChain = false;
        }

        js.append(mapping.generateJs());
        js.append(String.format(Locale.US, "var setData1" + ++variableIndex + " = " + jsBase + ".data(%s);",  ((mapping != null) ? mapping.getJsBase() : "null")));
        return this;
    }

    private String explode;
    private Double explode1;

    /**
     * Setter for the value of the exploded pie slice.<br/>
<b>Note:</b> Works only with exploded points mode.
     */
    public Pie setExplode(String explode) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".explode(%s)", wrapQuotes(explode)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".explode(%s)", wrapQuotes(explode)));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the value of the exploded pie slice.<br/>
<b>Note:</b> Works only with exploded points mode.
     */
    public Pie setExplode(Double explode1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".explode(%f)", explode1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".explode(%f)", explode1));
            js.setLength(0);
        }
        return this;
    }

    private Double index;
    private Boolean explode2;

    /**
     * Explodes slice at index.
     */
    public Pie explodeSlice(Double index, Boolean explode2) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".explodeSlice(%f, %b)", index, explode2));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".explodeSlice(%f, %b)", index, explode2));
            js.setLength(0);
        }
        return this;
    }

    private Boolean explodeSlices;

    /**
     * Explodes all slices.
     */
    public Pie explodeSlices(Boolean explodeSlices) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".explodeSlices(%b)", explodeSlices));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".explodeSlices(%b)", explodeSlices));
            js.setLength(0);
        }
        return this;
    }

    private Fill fill;

    /**
     * Setter for fill settings using an array or a string.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public Pie setFill(Fill fill) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s)", ((fill != null) ? fill.generateJs() : "null")));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s)", ((fill != null) ? fill.generateJs() : "null")));
            js.setLength(0);
        }
        return this;
    }

    private String color;
    private Double opacity;

    /**
     * Fill color with opacity.
     */
    public Pie fill(String color, Double opacity) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s, %f)", wrapQuotes(color), opacity));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f)", wrapQuotes(color), opacity));
            js.setLength(0);
        }
        return this;
    }

    private GradientKey[] keys;
    private String[] keys1;
    private Double angle;
    private Boolean mode;
    private VectorRect mode1;
    private String mode2;
    private Double opacity1;

    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public Pie fill(GradientKey[] keys, Boolean mode, Double angle, Double opacity1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s, %b, %f, %f)", arrayToString(keys), mode, angle, opacity1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %b, %f, %f)", arrayToString(keys), mode, angle, opacity1));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public Pie fill(GradientKey[] keys, VectorRect mode1, Double angle, Double opacity1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s, %s, %f, %f)", arrayToString(keys), ((mode1 != null) ? mode1.generateJs() : "null"), angle, opacity1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %s, %f, %f)", arrayToString(keys), ((mode1 != null) ? mode1.generateJs() : "null"), angle, opacity1));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public Pie fill(GradientKey[] keys, String mode2, Double angle, Double opacity1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s, %s, %f, %f)", arrayToString(keys), wrapQuotes(mode2), angle, opacity1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %s, %f, %f)", arrayToString(keys), wrapQuotes(mode2), angle, opacity1));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public Pie fill(String[] keys1, Boolean mode, Double angle, Double opacity1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s, %b, %f, %f)", arrayToStringWrapQuotes(keys1), mode, angle, opacity1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %b, %f, %f)", arrayToStringWrapQuotes(keys1), mode, angle, opacity1));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public Pie fill(String[] keys1, VectorRect mode1, Double angle, Double opacity1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s, %s, %f, %f)", arrayToStringWrapQuotes(keys1), ((mode1 != null) ? mode1.generateJs() : "null"), angle, opacity1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %s, %f, %f)", arrayToStringWrapQuotes(keys1), ((mode1 != null) ? mode1.generateJs() : "null"), angle, opacity1));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public Pie fill(String[] keys1, String mode2, Double angle, Double opacity1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s, %s, %f, %f)", arrayToStringWrapQuotes(keys1), wrapQuotes(mode2), angle, opacity1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %s, %f, %f)", arrayToStringWrapQuotes(keys1), wrapQuotes(mode2), angle, opacity1));
            js.setLength(0);
        }
        return this;
    }

    private GradientKey[] keys2;
    private String[] keys3;
    private Double cx;
    private Double cy;
    private GraphicsMathRect mode3;
    private Double opacity2;
    private Double fx;
    private Double fy;

    /**
     * Radial gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public Pie fill(GradientKey[] keys2, Double cx, Double cy, GraphicsMathRect mode3, Double opacity2, Double fx, Double fy) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s, %f, %f, %s, %f, %f, %f)", arrayToString(keys2), cx, cy, ((mode3 != null) ? mode3.generateJs() : "null"), opacity2, fx, fy));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %s, %f, %f, %f)", arrayToString(keys2), cx, cy, ((mode3 != null) ? mode3.generateJs() : "null"), opacity2, fx, fy));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Radial gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public Pie fill(String[] keys3, Double cx, Double cy, GraphicsMathRect mode3, Double opacity2, Double fx, Double fy) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".fill(%s, %f, %f, %s, %f, %f, %f)", arrayToStringWrapQuotes(keys3), cx, cy, ((mode3 != null) ? mode3.generateJs() : "null"), opacity2, fx, fy));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %s, %f, %f, %f)", arrayToStringWrapQuotes(keys3), cx, cy, ((mode3 != null) ? mode3.generateJs() : "null"), opacity2, fx, fy));
            js.setLength(0);
        }
        return this;
    }

    private Fill imageSettings;
    private Boolean forceHoverLabels;

    /**
     * Setter for the displaying of the label on hover event.
     */
    public Pie setForceHoverLabels(Boolean forceHoverLabels) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".forceHoverLabels(%b)", forceHoverLabels));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".forceHoverLabels(%b)", forceHoverLabels));
            js.setLength(0);
        }
        return this;
    }

    private String group;

    /**
     * Setter for the points grouping function.
     */
    public Pie setGroup(String group) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".group(%s)", wrapQuotes(group)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".group(%s)", wrapQuotes(group)));
            js.setLength(0);
        }
        return this;
    }


    private PatternFill getHatchFill;

    /**
     * Getter for the hatch fill settings.
     */
    public PatternFill getHatchFill() {
        if (getHatchFill == null)
            getHatchFill = new PatternFill(jsBase + ".hatchFill()");

        return getHatchFill;
    }
    private PatternFill patternFillOrType;
    private HatchFill patternFillOrType1;
    private HatchFillType patternFillOrType2;
    private String patternFillOrType3;
    private Boolean patternFillOrType4;
    private String color1;
    private Double thickness1;
    private Double size;

    /**
     * Setter for the hatch fill settings.
     */
    public Pie setHatchFill(PatternFill patternFillOrType, String color1, Double thickness1, Double size) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".hatchFill(%s, %s, %f, %f)", ((patternFillOrType != null) ? patternFillOrType.generateJs() : "null"), wrapQuotes(color1), thickness1, size));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".hatchFill(%s, %s, %f, %f)", ((patternFillOrType != null) ? patternFillOrType.generateJs() : "null"), wrapQuotes(color1), thickness1, size));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the hatch fill settings.
     */
    public Pie setHatchFill(HatchFill patternFillOrType1, String color1, Double thickness1, Double size) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".hatchFill(%s, %s, %f, %f)", ((patternFillOrType1 != null) ? patternFillOrType1.generateJs() : "null"), wrapQuotes(color1), thickness1, size));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".hatchFill(%s, %s, %f, %f)", ((patternFillOrType1 != null) ? patternFillOrType1.generateJs() : "null"), wrapQuotes(color1), thickness1, size));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the hatch fill settings.
     */
    public Pie setHatchFill(HatchFillType patternFillOrType2, String color1, Double thickness1, Double size) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".hatchFill(%s, %s, %f, %f)", ((patternFillOrType2 != null) ? patternFillOrType2.generateJs() : "null"), wrapQuotes(color1), thickness1, size));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".hatchFill(%s, %s, %f, %f)", ((patternFillOrType2 != null) ? patternFillOrType2.generateJs() : "null"), wrapQuotes(color1), thickness1, size));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the hatch fill settings.
     */
    public Pie setHatchFill(String patternFillOrType3, String color1, Double thickness1, Double size) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".hatchFill(%s, %s, %f, %f)", wrapQuotes(patternFillOrType3), wrapQuotes(color1), thickness1, size));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".hatchFill(%s, %s, %f, %f)", wrapQuotes(patternFillOrType3), wrapQuotes(color1), thickness1, size));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the hatch fill settings.
     */
    public Pie setHatchFill(Boolean patternFillOrType4, String color1, Double thickness1, Double size) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".hatchFill(%b, %s, %f, %f)", patternFillOrType4, wrapQuotes(color1), thickness1, size));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".hatchFill(%b, %s, %f, %f)", patternFillOrType4, wrapQuotes(color1), thickness1, size));
            js.setLength(0);
        }
        return this;
    }


    private HatchFills getHatchFillPalette;

    /**
     * Getter for hatch fill palette settings.
     */
    public HatchFills getHatchFillPalette() {
        if (getHatchFillPalette == null)
            getHatchFillPalette = new HatchFills(jsBase + ".hatchFillPalette()");

        return getHatchFillPalette;
    }
    private HatchFillType[] hatchFillPalette;
    private String hatchFillPalette1;
    private HatchFills hatchFillPalette2;

    /**
     * Setter for hatch fill palette settings.<br/>
<b>Note:</b> Works only with {@link anychart.charts.Pie#hatchFill} method.
     */
    public Pie setHatchFillPalette(HatchFillType[] hatchFillPalette) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".hatchFillPalette(%s)", arrayToString(hatchFillPalette)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".hatchFillPalette(%s)", arrayToString(hatchFillPalette)));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for hatch fill palette settings.<br/>
<b>Note:</b> Works only with {@link anychart.charts.Pie#hatchFill} method.
     */
    public Pie setHatchFillPalette(String hatchFillPalette1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".hatchFillPalette(%s)", wrapQuotes(hatchFillPalette1)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".hatchFillPalette(%s)", wrapQuotes(hatchFillPalette1)));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for hatch fill palette settings.<br/>
<b>Note:</b> Works only with {@link anychart.charts.Pie#hatchFill} method.
     */
    public Pie setHatchFillPalette(HatchFills hatchFillPalette2) {
        if (isChain) {
            js.append(";");
            isChain = false;
        }
        js.append(hatchFillPalette2.generateJs());
        js.append(jsBase);

        js.append(String.format(Locale.US, ".hatchFillPalette(%s);",  ((hatchFillPalette2 != null) ? hatchFillPalette2.getJsBase() : "null")));
        return this;
    }

    private Double index1;

    /**
     * Setter for the hover state on a slice by index.
     */
    public Pie setHover(Double index1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".hover(%f)", index1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".hover(%f)", index1));
            js.setLength(0);
        }
        return this;
    }


    private StateSettings getHovered;

    /**
     * Getter for hovered state settings.
     */
    public StateSettings getHovered() {
        if (getHovered == null)
            getHovered = new StateSettings(jsBase + ".hovered()");

        return getHovered;
    }
    private String hovered;

    /**
     * Setter for hovered state settings.
     */
    public Pie setHovered(String hovered) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".hovered(%s)", wrapQuotes(hovered)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".hovered(%s)", wrapQuotes(hovered)));
            js.setLength(0);
        }
        return this;
    }

    private String innerRadius;
    private Double innerRadius1;

    /**
     * Setter for the inner radius in case of a Donut chart.
     */
    public Pie setInnerRadius(String innerRadius) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".innerRadius(%s)", wrapQuotes(innerRadius)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".innerRadius(%s)", wrapQuotes(innerRadius)));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the inner radius in case of a Donut chart.
     */
    public Pie setInnerRadius(Double innerRadius1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".innerRadius(%f)", innerRadius1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".innerRadius(%f)", innerRadius1));
            js.setLength(0);
        }
        return this;
    }

    private Double insideLabelsOffset;
    private String insideLabelsOffset1;

    /**
     * Setter for inside labels space settings.<br/>
<b>Note:</b> Works only with inside labels mode.
     */
    public Pie setInsideLabelsOffset(Double insideLabelsOffset) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".insideLabelsOffset(%f)", insideLabelsOffset));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".insideLabelsOffset(%f)", insideLabelsOffset));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for inside labels space settings.<br/>
<b>Note:</b> Works only with inside labels mode.
     */
    public Pie setInsideLabelsOffset(String insideLabelsOffset1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".insideLabelsOffset(%s)", wrapQuotes(insideLabelsOffset1)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".insideLabelsOffset(%s)", wrapQuotes(insideLabelsOffset1)));
            js.setLength(0);
        }
        return this;
    }


    private UiLabelsFactory getLabels;

    /**
     * Getter for the pie labels.
     */
    public UiLabelsFactory getLabels() {
        if (getLabels == null)
            getLabels = new UiLabelsFactory(jsBase + ".labels()");

        return getLabels;
    }
    private String labels;
    private Boolean labels1;

    /**
     * Setter for the pie labels.
     */
    public Pie setLabels(String labels) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".labels(%s)", wrapQuotes(labels)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".labels(%s)", wrapQuotes(labels)));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the pie labels.
     */
    public Pie setLabels(Boolean labels1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".labels(%b)", labels1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".labels(%b)", labels1));
            js.setLength(0);
        }
        return this;
    }


    private StateSettings getNormal;

    /**
     * Getter for normal state settings.
     */
    public StateSettings getNormal() {
        if (getNormal == null)
            getNormal = new StateSettings(jsBase + ".normal()");

        return getNormal;
    }
    private String normal;

    /**
     * Setter for normal state settings.
     */
    public Pie setNormal(String normal) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".normal(%s)", wrapQuotes(normal)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".normal(%s)", wrapQuotes(normal)));
            js.setLength(0);
        }
        return this;
    }

    private Double outsideLabelsCriticalAngle;
    private String outsideLabelsCriticalAngle1;

    /**
     * Setter for the outside labels connector critical angle settings.<br/>
<b>Note:</b> Works only with outside labels mode.
     */
    public Pie setOutsideLabelsCriticalAngle(Double outsideLabelsCriticalAngle) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".outsideLabelsCriticalAngle(%f)", outsideLabelsCriticalAngle));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".outsideLabelsCriticalAngle(%f)", outsideLabelsCriticalAngle));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the outside labels connector critical angle settings.<br/>
<b>Note:</b> Works only with outside labels mode.
     */
    public Pie setOutsideLabelsCriticalAngle(String outsideLabelsCriticalAngle1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".outsideLabelsCriticalAngle(%s)", wrapQuotes(outsideLabelsCriticalAngle1)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".outsideLabelsCriticalAngle(%s)", wrapQuotes(outsideLabelsCriticalAngle1)));
            js.setLength(0);
        }
        return this;
    }

    private Double outsideLabelsSpace;
    private String outsideLabelsSpace1;

    /**
     * Setter for the outside labels space settings.<br/>
<b>Note:</b> Works only with outside labels mode.
     */
    public Pie setOutsideLabelsSpace(Double outsideLabelsSpace) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".outsideLabelsSpace(%f)", outsideLabelsSpace));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".outsideLabelsSpace(%f)", outsideLabelsSpace));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the outside labels space settings.<br/>
<b>Note:</b> Works only with outside labels mode.
     */
    public Pie setOutsideLabelsSpace(String outsideLabelsSpace1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".outsideLabelsSpace(%s)", wrapQuotes(outsideLabelsSpace1)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".outsideLabelsSpace(%s)", wrapQuotes(outsideLabelsSpace1)));
            js.setLength(0);
        }
        return this;
    }

    private LabelsOverlapMode overlapMode;
    private String overlapMode1;
    private Boolean overlapMode2;

    /**
     * Setter for the overlap mode for labels.
     */
    public Pie setOverlapMode(LabelsOverlapMode overlapMode) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".overlapMode(%s)", ((overlapMode != null) ? overlapMode.generateJs() : "null")));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".overlapMode(%s)", ((overlapMode != null) ? overlapMode.generateJs() : "null")));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the overlap mode for labels.
     */
    public Pie setOverlapMode(String overlapMode1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".overlapMode(%s)", wrapQuotes(overlapMode1)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".overlapMode(%s)", wrapQuotes(overlapMode1)));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the overlap mode for labels.
     */
    public Pie setOverlapMode(Boolean overlapMode2) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".overlapMode(%b)", overlapMode2));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".overlapMode(%b)", overlapMode2));
            js.setLength(0);
        }
        return this;
    }


    private RangeColors getPalette;

    /**
     * Getter for the pie palette.
     */
    public RangeColors getPalette() {
        if (getPalette == null)
            getPalette = new RangeColors(jsBase + ".palette()");

        return getPalette;
    }
    private RangeColors palette;
    private DistinctColors palette1;
    private String palette2;
    private String[] palette3;

    /**
     * Setter for the pie palette.
<b>Note</b>: You can use predefined palettes from {@link anychart.palettes}.
     */
    public Pie setPalette(RangeColors palette) {
        if (isChain) {
            js.append(";");
            isChain = false;
        }
        js.append(palette.generateJs());
        js.append(jsBase);

        js.append(String.format(Locale.US, ".palette(%s);",  ((palette != null) ? palette.getJsBase() : "null")));
        return this;
    }


    /**
     * Setter for the pie palette.
<b>Note</b>: You can use predefined palettes from {@link anychart.palettes}.
     */
    public Pie setPalette(DistinctColors palette1) {
        if (isChain) {
            js.append(";");
            isChain = false;
        }
        js.append(palette1.generateJs());
        js.append(jsBase);

        js.append(String.format(Locale.US, ".palette(%s);",  ((palette1 != null) ? palette1.getJsBase() : "null")));
        return this;
    }


    /**
     * Setter for the pie palette.
<b>Note</b>: You can use predefined palettes from {@link anychart.palettes}.
     */
    public Pie setPalette(String palette2) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".palette(%s)", wrapQuotes(palette2)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".palette(%s)", wrapQuotes(palette2)));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the pie palette.
<b>Note</b>: You can use predefined palettes from {@link anychart.palettes}.
     */
    public Pie setPalette(String[] palette3) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".palette(%s)", arrayToStringWrapQuotes(palette3)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".palette(%s)", arrayToStringWrapQuotes(palette3)));
            js.setLength(0);
        }
        return this;
    }

    private String radius;
    private Double radius1;

    /**
     * Setter for the outer pie radius.
     */
    public Pie setRadius(String radius) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".radius(%s)", wrapQuotes(radius)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".radius(%s)", wrapQuotes(radius)));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the outer pie radius.
     */
    public Pie setRadius(Double radius1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".radius(%f)", radius1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".radius(%f)", radius1));
            js.setLength(0);
        }
        return this;
    }

    private Sort sort;
    private String sort1;

    /**
     * Setter for the sorting setting.<br/>
Ascending, Descending and No sorting is supported.
     */
    public Pie setSort(Sort sort) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".sort(%s)", ((sort != null) ? sort.generateJs() : "null")));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".sort(%s)", ((sort != null) ? sort.generateJs() : "null")));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the sorting setting.<br/>
Ascending, Descending and No sorting is supported.
     */
    public Pie setSort(String sort1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".sort(%s)", wrapQuotes(sort1)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".sort(%s)", wrapQuotes(sort1)));
            js.setLength(0);
        }
        return this;
    }

    private String startAngle;
    private Double startAngle1;

    /**
     * Setter for the angle of the first slice.
     */
    public Pie setStartAngle(String startAngle) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".startAngle(%s)", wrapQuotes(startAngle)));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".startAngle(%s)", wrapQuotes(startAngle)));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the angle of the first slice.
     */
    public Pie setStartAngle(Double startAngle1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".startAngle(%f)", startAngle1));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".startAngle(%f)", startAngle1));
            js.setLength(0);
        }
        return this;
    }

    private Stroke stroke;
    private ColoredFill stroke1;
    private String stroke2;
    private Double thickness2;
    private String dashpattern1;
    private StrokeLineJoin lineJoin1;
    private StrokeLineCap lineCap1;

    /**
     * Setter for the pie slices stroke.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public Pie setStroke(Stroke stroke, Double thickness2, String dashpattern1, StrokeLineJoin lineJoin1, StrokeLineCap lineCap1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", ((stroke != null) ? stroke.generateJs() : "null"), thickness2, wrapQuotes(dashpattern1), ((lineJoin1 != null) ? lineJoin1.generateJs() : "null"), ((lineCap1 != null) ? lineCap1.generateJs() : "null")));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", ((stroke != null) ? stroke.generateJs() : "null"), thickness2, wrapQuotes(dashpattern1), ((lineJoin1 != null) ? lineJoin1.generateJs() : "null"), ((lineCap1 != null) ? lineCap1.generateJs() : "null")));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the pie slices stroke.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public Pie setStroke(ColoredFill stroke1, Double thickness2, String dashpattern1, StrokeLineJoin lineJoin1, StrokeLineCap lineCap1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", ((stroke1 != null) ? stroke1.generateJs() : "null"), thickness2, wrapQuotes(dashpattern1), ((lineJoin1 != null) ? lineJoin1.generateJs() : "null"), ((lineCap1 != null) ? lineCap1.generateJs() : "null")));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", ((stroke1 != null) ? stroke1.generateJs() : "null"), thickness2, wrapQuotes(dashpattern1), ((lineJoin1 != null) ? lineJoin1.generateJs() : "null"), ((lineCap1 != null) ? lineCap1.generateJs() : "null")));
            js.setLength(0);
        }
        return this;
    }


    /**
     * Setter for the pie slices stroke.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public Pie setStroke(String stroke2, Double thickness2, String dashpattern1, StrokeLineJoin lineJoin1, StrokeLineCap lineCap1) {
        if (!isChain) {
            js.append(jsBase);
            isChain = true;
        }
        js.append(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", wrapQuotes(stroke2), thickness2, wrapQuotes(dashpattern1), ((lineJoin1 != null) ? lineJoin1.generateJs() : "null"), ((lineCap1 != null) ? lineCap1.generateJs() : "null")));

        if (isRendered) {
            onChangeListener.onChange(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", wrapQuotes(stroke2), thickness2, wrapQuotes(dashpattern1), ((lineJoin1 != null) ? lineJoin1.generateJs() : "null"), ((lineCap1 != null) ? lineCap1.generateJs() : "null")));
            js.setLength(0);
        }
        return this;
    }

    private String generateJSgetData() {
        if (getData != null) {
            return getData.generateJs();
        }
        return "";
    }

    private String generateJSgetHatchFill() {
        if (getHatchFill != null) {
            return getHatchFill.generateJs();
        }
        return "";
    }

    private String generateJSgetHatchFillPalette() {
        if (getHatchFillPalette != null) {
            return getHatchFillPalette.generateJs();
        }
        return "";
    }

    private String generateJSgetHovered() {
        if (getHovered != null) {
            return getHovered.generateJs();
        }
        return "";
    }

    private String generateJSgetLabels() {
        if (getLabels != null) {
            return getLabels.generateJs();
        }
        return "";
    }

    private String generateJSgetNormal() {
        if (getNormal != null) {
            return getNormal.generateJs();
        }
        return "";
    }

    private String generateJSgetPalette() {
        if (getPalette != null) {
            return getPalette.generateJs();
        }
        return "";
    }


    @Override
    protected String generateJs() {
        if (isChain) {
            js.append(";");
            isChain = false;
        }
        js.append(generateJSgetData());
        js.append(generateJSgetHatchFill());
        js.append(generateJSgetHatchFillPalette());
        js.append(generateJSgetHovered());
        js.append(generateJSgetLabels());
        js.append(generateJSgetNormal());
        js.append(generateJSgetPalette());

        js.append(super.generateJsGetters());
        js.append(super.generateJs());

        String result = js.toString();
        js.setLength(0);
        return result;
    }

}