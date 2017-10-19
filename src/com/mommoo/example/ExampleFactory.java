package com.mommoo.example;

import com.mommoo.flat.button.FlatButton;
import com.mommoo.flat.component.FlatPanel;
import com.mommoo.flat.frame.FlatFrame;
import com.mommoo.flat.image.FlatImagePanel;
import com.mommoo.flat.image.ImageOption;
import com.mommoo.flat.layout.linear.LinearLayout;
import com.mommoo.flat.layout.linear.Orientation;
import com.mommoo.flat.layout.linear.constraints.LinearConstraints;
import com.mommoo.flat.layout.linear.constraints.LinearSpace;
import com.mommoo.flat.list.FlatListView;
import com.mommoo.flat.text.label.FlatLabel;
import com.mommoo.flat.text.textarea.FlatTextAlignment;
import com.mommoo.flat.text.textfield.FlatTextField;
import com.mommoo.flat.text.textfield.format.FlatTextFormat;
import com.mommoo.util.FontManager;
import com.mommoo.util.ImageManager;

import java.awt.*;

public class ExampleFactory {
    static FlatFrame createCommonFrame() {
        FlatFrame commonFrame = new FlatFrame();
        commonFrame.setSize(700, 700);
        commonFrame.setLocationOnScreenCenter();

        return commonFrame;
    }

    public static class FlatImagePanelExample {
        public static void example1() {
            FlatFrame frame = createCommonFrame();
            frame.setTitle("Example1 : Grid Image Galley(3x3) ");
            frame.getContainer().setLayout(new LinearLayout(Orientation.VERTICAL));

            frame.getContainer().add(createPanelOfImages(ImageManager.CAT, ImageManager.DOG, ImageManager.FROG), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            frame.getContainer().add(createPanelOfImages(ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            frame.getContainer().add(createPanelOfImages(ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));

            frame.show();
        }

        public static void example2() {
            FlatFrame frame = createCommonFrame();
            frame.setTitle("Example2 : Grid Image Galley(9x9) ");
//            frame.getContainer().setLayout(new LinearLayout(Orientation.VERTICAL));
            FlatPanel panel = new FlatPanel(new LinearLayout(Orientation.VERTICAL));
            panel.setForeground(new Color(0,0,0,20));
            panel.setBackground(new Color(24, 24, 24,20));
            frame.getContainer().add(panel);
            panel.add(createPanelOfImages(ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG, ImageManager.CAT, ImageManager.DOG, ImageManager.FROG, ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            panel.add(createPanelOfImages(ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP, ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG, ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            panel.add(createPanelOfImages(ImageManager.CAT, ImageManager.DOG, ImageManager.FROG, ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP, ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));

            panel.add(createPanelOfImages(ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP, ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG, ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            panel.add(createPanelOfImages(ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG, ImageManager.CAT, ImageManager.DOG, ImageManager.FROG, ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            panel.add(createPanelOfImages(ImageManager.CAT, ImageManager.DOG, ImageManager.FROG, ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP, ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));

            panel.add(createPanelOfImages(ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG, ImageManager.CAT, ImageManager.DOG, ImageManager.FROG, ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            panel.add(createPanelOfImages(ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP, ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG, ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            panel.add(createPanelOfImages(ImageManager.CAT, ImageManager.DOG, ImageManager.FROG, ImageManager.TIGER, ImageManager.PANDA, ImageManager.SHEEP, ImageManager.LION, ImageManager.GIRIN, ImageManager.PIG), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));

            frame.show();
        }

        private static Component createPanelOfImages(Image... images) {
            FlatPanel parentPanel = new FlatPanel(new LinearLayout());
            for (Image image : images) {
                FlatImagePanel flatImagePanel = new FlatImagePanel(image, ImageOption.MATCH_PARENT);
                parentPanel.add(flatImagePanel, new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            }

            return parentPanel;
        }
    }

    public static class FlatListViewExample {
        public static void example1() {
            FlatFrame frame = createCommonFrame();
            frame.setTitle("Example1 : Auto Scrolling");
            frame.getContainer().setLayout(new LinearLayout(Orientation.VERTICAL));

            FlatPanel insertPanel = new FlatPanel(new LinearLayout());
            FlatTextField textField = new FlatTextField(false);
            insertPanel.add(textField, new LinearConstraints().setWeight(4).setLinearSpace(LinearSpace.MATCH_PARENT));
            FlatButton button = new FlatButton("INSERT");
            insertPanel.add(button, new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));

            frame.getContainer().add(insertPanel, new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            FlatListView<FlatLabel> listView = new FlatListView<>();
            frame.getContainer().add(listView.getComponent(), new LinearConstraints().setWeight(5).setLinearSpace(LinearSpace.MATCH_PARENT));

            button.setOnClickListener(e -> {
                FlatLabel label = new FlatLabel("POSITION " + (listView.getItemSize() + 1) + " : " + textField.getText());
                label.setFont(label.getFont().deriveFont(30.0f));
                listView.addItem(label);
                listView.getScroller().smoothScrollByPosition(true, listView.getItemSize() - 1);
            });

            frame.show();
        }

        public static void example2(){
            FlatFrame frame = createCommonFrame();
            frame.setSize(250,500);
            frame.setTitle("Example2 : panelWrap Test");
            frame.getContainer().setLayout(new LinearLayout(Orientation.VERTICAL));
            FlatListView<FlatPanel> listView = new FlatListView<>();
            Font font = FontManager.getNanumGothicFont(Font.BOLD, 30);
            for (int i = 0 ; i < 30 ; i++){
                listView.addItem(createWrapPanel("position : " + (i + 1),font));
            }
            frame.getContainer().add(listView.getComponent(), new LinearConstraints().setWeight(5).setLinearSpace(LinearSpace.MATCH_PARENT));
            frame.show();
        }

        private static FlatPanel createWrapPanel(String text,Font font){
            FlatPanel panel = new FlatPanel(new BorderLayout());
            panel.setAlpha(0.8f);
            FlatLabel label = new FlatLabel(text);
            label.setTextAlignment(FlatTextAlignment.ALIGN_CENTER);
            label.setVerticalCenteredTextAlignment();
//            panel.setPreferredSize(new Dimension(1,50));
            label.setFont(font);
            panel.add(label);
            return panel;
        }
    }

    public static class FlatTextFieldExample {
        public static void example1() {
            FlatFrame frame = createCommonFrame();
            frame.setTitle("Example1 : Ten of TextField");
            frame.getContainer().setLayout(new LinearLayout(Orientation.VERTICAL));

            for (int i = 0; i < 10; i++) {
                FlatTextField component = new FlatTextField(true);
                component.setHint("HINT");
                component.setFormat(FlatTextFormat.NUMBER_DECIMAL);
                component.setHintForeground(Color.BLUE);
                component.setForeground(Color.RED);
                frame.getContainer().add(component, new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            }
            ((FlatTextField)frame.getContainer().getComponent(3)).setText("가나다");
            frame.show();
        }
    }
}
