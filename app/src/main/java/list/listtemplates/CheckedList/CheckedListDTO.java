package list.listtemplates.CheckedList;

import java.io.Serializable;

/**
 * Created by CHANDRASAIMOHAN on 8/20/2016.
 */
public class CheckedListDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private    int iconId;
  private   String title;
  private boolean isSelected;

  public CheckedListDTO(int iconId, String title, boolean isSelected) {

    this.iconId = iconId;
    this.title = title;
    this.isSelected = isSelected;
  }

  public int getIconId() {
    return iconId;
  }

  public void setIconId(int iconId) {
    this.iconId = iconId;
  }

  public boolean isSelected() {
    return isSelected;
  }

  public void setSelected(boolean selected) {
    isSelected = selected;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
