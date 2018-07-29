package warframe.notifier.notification;

import java.awt.BorderLayout;
import java.awt.FontMetrics;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.notification.NotificationBuilder;
import com.notification.types.BorderLayoutNotification;
import com.theme.TextTheme;
import com.theme.ThemePackage;
import com.theme.WindowTheme;

/**
 * This is a CustomNotification which will only have one line of text and a button that will turn into a progress bar.
 */
public class WarframeNotification extends BorderLayoutNotification {
	protected JLabel titleElement;
	protected JTextArea messageElement;

	private TextTheme textTheme;
	private WindowTheme windowTheme;
	
	public WarframeNotification() {
		titleElement = new JLabel();
		messageElement = new JTextArea();

		this.addComponent(titleElement, BorderLayout.NORTH);
		this.addComponent(messageElement, BorderLayout.CENTER);
	}

	/**
	 * This will set the title and subtitle font and color.
	 *
	 * @param theme
	 *            the TextTheme to set
	 */
	public void setTextTheme(TextTheme theme) {
		titleElement.setFont(theme.title);
		titleElement.setForeground(theme.titleColor);
		messageElement.setFont(theme.subtitle);
		messageElement.setForeground(theme.subtitleColor);

		textTheme = theme;
	}

	@Override
	public void setWindowTheme(WindowTheme theme) {
		super.setWindowTheme(theme);
	}

	public static class CustomBuilder implements NotificationBuilder<WarframeNotification> {
		@Override
		public WarframeNotification buildNotification(ThemePackage pack, Object... args) {
			WarframeNotification note = new WarframeNotification();
			// handled by the WindowNotification first, then we override the values we want to keep
			note.setWindowTheme(pack.getTheme(WindowTheme.class));
			// handled by us
			note.setTextTheme(pack.getTheme(TextTheme.class));

			if (args.length > 0) {
				note.setTitle((String) args[0]);
				if(args.length>1){
					note.setMessage((String) args[1]);
				}else{
					note.setMessage("No text supplied");
				}
			} else {
				note.setTitle("No text supplied");
			}
			return note;
		}
	}
	public String getTitle() {
		return titleElement.getText();
	}

	public void setTitle(String title) {
		titleElement.setText(title);
	}

	public String getMessage() {
		return messageElement.getText();
	}

	public void setMessage(String message) {
		messageElement.setText(message);
	}
	
	public FontMetrics getMessageMetrics(){
		return messageElement.getFontMetrics(messageElement.getFont());
	}
	public FontMetrics getTitleMetrics(){
		return titleElement.getFontMetrics(titleElement.getFont());
	}
	
}