@CLS

@SET HOME=%cd%
@SET HOME_SOURCE=%HOME%\mp-cloud-develop\webroot\WEB-INF\content\cloud\design.persistence

@SET HOME_TARGET=%HOME%\mp-cloud-design\webroot\WEB-INF\content\system\design.persistence
XCOPY /E /Y %HOME_SOURCE% %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-cloud-content\webroot\WEB-INF\content\cloud\design.persistence
XCOPY /E /Y %HOME_SOURCE% %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-cloud-editor\webroot\WEB-INF\content\cloud\design.persistence
XCOPY /E /Y %HOME_SOURCE% %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-eai-content\webroot\WEB-INF\content\cloud\design.persistence
XCOPY /E /Y %HOME_SOURCE% %HOME_TARGET%
