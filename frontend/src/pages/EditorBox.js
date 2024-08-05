// EditorBox.js
import React, {useState} from 'react';
import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css';
import '@toast-ui/editor/dist/i18n/ko-kr'; // 한국어 번역 파일을 추가
import colorSyntax from '@toast-ui/editor-plugin-color-syntax';
import ContentsViewer from './ContentsViewer';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';

function EditorBox() {
    const [isViewing, setIsViewing] = useState(false);
    const [editorContent, setEditorContent] = useState("등록하고 싶은 챌린지를 등록해주세요");

    const handleToggleMode =() => {
        setIsViewing(prev => !prev);
    };

    const handleEditorChange = (editor) => {
        setEditorContent(editor.getHtml());
    };

  return (
    <div className="edit_wrap">
        {isViewing ? (
            <ContentsViewer contents={editorContent} /> 
        ) : (
          <Editor
            initialValue={editorContent}
            previewStyle="vertical"
            height="600px"
            initialEditType="wysiwyg"
            useCommandShortcut={false}
            plugins={[colorSyntax]}
            language="ko-KR"
            onChange={handleEditorChange}
         />  
        )}
        <button onClick={handleToggleMode}>
            {isViewing ? '편집 모드로 전환' : '보기 모드로 전환'} {}
        </button>
    </div>
  );
}

export default EditorBox;
