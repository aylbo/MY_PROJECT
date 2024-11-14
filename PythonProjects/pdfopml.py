from pypdf import PdfReader
import re

def extract_urls_from_pdf(pdf_path):
    """Extracts all URLs from the given PDF file."""
    reader = PdfReader(pdf_path)
    urls = set()  # Use a set to avoid duplicates
    
    # Regular expression to match URLs
    url_pattern = re.compile(r'(https?://[^\s]+)')
    
    for page in reader.pages:
        text = page.extract_text()
        if text:
            # Find all URLs in the page text
            found_urls = url_pattern.findall(text)
            urls.update(found_urls)
        
        # Check for URLs in annotations (like hyperlinks)
        if '/Annots' in page:
            for annot in page['/Annots']:
                annot_obj = annot.get_object()
                if '/A' in annot_obj and '/URI' in annot_obj['/A']:
                    urls.add(annot_obj['/A']['/URI'])
    
    return list(urls)

def save_urls_to_file(urls, output_path):
    """Saves the extracted URLs to a text file."""
    with open(output_path, 'w') as f:
        for url in urls:
            f.write("'" + url + "',\n")

# Example usage
pdf_path = '/Users/aylinoncel/Library/Mobile Documents/com~apple~CloudDocs/Book List.pdf'
output_path =  '/Users/aylinoncel/Library/Mobile Documents/com~apple~CloudDocs/Book List.txt'

# Extract URLs and save them to a file
urls = extract_urls_from_pdf(pdf_path)
save_urls_to_file(urls, output_path)

print(f"Extracted {len(urls)} URLs. Check {output_path} for the list.")