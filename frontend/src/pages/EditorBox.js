import React, { useState, useRef } from 'react';
import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css';
import '@toast-ui/editor/dist/i18n/ko-kr'; // 한국어 번역 파일을 추가
import colorSyntax from '@toast-ui/editor-plugin-color-syntax';
import ContentsViewer from './ContentsViewer';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';

function EditorBox(props) {
    const [isViewing, setIsViewing] = useState(false);
    //const [editorContent, props.setContent] = useState(' ');

    const editorRef = useRef();

    const handleToggleMode = () => {
        setIsViewing(prev => !prev);
    };

    const handleEditorChange = () => {
        const editorInstance = editorRef.current.getInstance();
        props.setContent(editorInstance.getHTML());
    };

    const onUploadImage = async (blob, callback) => {
        // 이미지를 업로드할 서버 API 호출
        const formData = new FormData();
        formData.append('file', blob);

        try {
            const response = await fetch('/api/upload-image', {
                method: 'POST',
                body: formData,
            });

            if (response.ok) {
                const data = await response.json();
                const url = data.url; // 업로드된 이미지의 URL
                callback(url, 'alt text');
            } else {
                console.error('Image upload failed');
            }
        } catch (error) {
            console.error('Error uploading image:', error);
        }

        return false;
    };

    return (
        <div className="edit_wrap">
            {isViewing ? (
                <ContentsViewer contents={props.content} /> 
            ) : (
                <Editor
                    ref={editorRef}
                    initialValue={props.content}
                    previewStyle="vertical"
                    height="600px"
                    initialEditType="wysiwyg"
                    useCommandShortcut={false}
                    plugins={[colorSyntax]}
                    language="ko-KR"
                    placeholder="등록해주세요"
                    onChange={handleEditorChange}
                    hideModeSwitch={true}
                    hooks={{
                        addImageBlobHook: onUploadImage,
                    }}
                />  
            )}
            <button onClick={handleToggleMode}>
                {isViewing ? '편집 모드로 전환' : '보기 모드로 전환'}
            </button>
        </div>
    );
}

export default EditorBox;
